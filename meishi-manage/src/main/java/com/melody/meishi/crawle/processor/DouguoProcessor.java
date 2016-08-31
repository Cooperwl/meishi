package com.melody.meishi.crawle.processor;

import com.meishi.common.util.StringUtils;
import com.meishi.metadata.ws.food.dto.FoodDTO;
import com.meishi.metadata.ws.food.dto.FoodMaterialDTO;
import com.meishi.metadata.ws.food.dto.FoodStepDTO;
import com.melody.meishi.crawle.FoodIdGenerator;
import com.melody.meishi.crawle.MaterialMap;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.utils.UrlUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DouguoProcessor implements PageProcessor {

    private Site site;
    private String type;//类型 （家常菜、东北菜。。。）
    public DouguoProcessor(String startUrl, String type) {
        this.site = Site.me().setDomain(UrlUtils.getDomain(startUrl));
        this.type = type;
    }

    @Override
    public void process(Page page) {
        Selectable url = page.getUrl();

        if (url != null && !url.toString().endsWith(".html")) {
            if (!url.toString().contains(type)) {
                return;
            }
            addUrlToPage(page);
        } else {
            FoodDTO dto = parseFood(page);
            page.putField("meishi", dto);
        }
    }

    /**
     * 解析页面，获取美食
     *
     * @param page
     * @return
     */
    private FoodDTO parseFood(Page page) {
        //美食内容
        Selectable recinfo = page.getHtml().$("div.recinfo");
        FoodDTO dto = new FoodDTO();
        dto.setId(FoodIdGenerator.generateID());
        dto.setCatId(0);
        dto.setChefId(0L);
        dto.setCreateDate(new Date());
        //查找title
//            <h1 id="page_cm_id" ctype="caipu" uid="10973463" val="1401196" style="padding-bottom: 10px;">  微波炉烤茄子｜日食记</h1>
        String title = recinfo.xpath("//h1/text()").toString();
        dto.setTitle(title);
        //查找图片
        String img = recinfo.$("div.bokpic").xpath("//img/@src").toString();
        dto.setMainPic(img);
        //story
//            <div style="display: none;" class="xtip hidden" id="fullStory">
//                    最近温度一天高过一天，工作室每天都有同事要因为天气嚎叫一番。尽管开了空调，但大家的饭量都明显缩小了，特别是我公司的后期狗们，生活没有了食欲支撑，每天个个都生无可恋。<br><br>大鱼大肉吃不下，蔬菜口味太清淡不下饭。其实不止吃饭的问题，就算想去做个饭，守在炉灶旁的温度也实在太令人烦躁。直到翻到了【微波炉烤茄子】这道菜。<br><br>调味后的蒜香四溢，连不爱吃蒜的女生都停不下来。一盘烤茄子端出，香气扑鼻，筷子夹起一丝柔软的茄肉，仿佛会融化在嘴里。要说比肉更可口的蔬菜，几乎找不到比这道菜更贴切的了。
//              </div>
        String fullStory = recinfo.$("#fullStory").xpath("//div/text()").toString();
        dto.setDescription(fullStory);
        //获取主辅料
        List<Selectable> trNodes = recinfo.$("table.retamr tbody tr").nodes();
        List<FoodMaterialDTO> mateirals = new ArrayList<>();
        for (Selectable _tr : trNodes) {
            String _trClass = _tr.xpath("//tr/@class").toString();
            //主辅料标签
            if ("mtim".equals(_trClass)) {
                continue;
            }
            List<Selectable> _tdNode = _tr.$("td").nodes();
            for (Selectable _td : _tdNode) {

                FoodMaterialDTO mateiral = new FoodMaterialDTO();
                mateiral.setFoodId(dto.getId());
                mateiral.setId(FoodIdGenerator.generateID());
                List<Selectable> _spanNodes = _td.$("span").nodes();
                for (Selectable _span : _spanNodes) {
                    Selectable linkNode = _span.$("a");
                    Selectable labelNode = _span.$("label");
                    if (null != linkNode && null != linkNode.toString()) {//主料标签，有链接
                        mateiral.setMaterialName(_span.xpath("//a/text()").toString());
                    } else if (null != labelNode && null != labelNode.toString()) {//辅料标签无连接
                        mateiral.setMaterialName(_span.xpath("//label/text()").toString());
                    } else {//用量标签
                        String dosage = _span.xpath("//span/text()").toString();
                        if (!StringUtils.isNullOrEmpty(dosage)) {
                            mateiral.setUsedAmount(dosage);
                        }
                    }
                }
                mateiral.setMaterialId(MaterialMap.getinstance().put(mateiral.getMaterialName()));
                mateirals.add(mateiral);
            }
        }
        dto.setMaterials(mateirals);
        List<FoodStepDTO> cookSteps = new ArrayList<>();
        List<Selectable> steps = recinfo.$("div.step div.stepcont").nodes();
        for (int i = 0, len = steps.size(); i < len; i++) {
            Selectable div = steps.get(i);
            String pic = div.xpath("//img/@original").toString();
            String step = div.xpath("//p/text()").toString();
            FoodStepDTO stepDTO = new FoodStepDTO();
            stepDTO.setFoodId(dto.getId());
            stepDTO.setId(FoodIdGenerator.generateID());
            stepDTO.setImage(pic);
            stepDTO.setDescription(step);
            stepDTO.setSequence(i + 1);
            cookSteps.add(stepDTO);
        }
        dto.setFoodSteps(cookSteps);
        return dto;
    }

    /**
     * 不是以html结尾的页面，说明不是具体的菜谱页，则需要解析页面并添加相关的链接到page中
     *
     * @param page
     */
    private void addUrlToPage(Page page) {
        List<Selectable> paginationSpans = page.getHtml().$("div.page_PN div.pagination span").nodes();
        int currentPosition = 0;//寻找到当前页面的编号
        for (int i = 0, l = paginationSpans.size(); i < l; i++) {
            Selectable spanNode = paginationSpans.get(i);
            String clazz = spanNode.xpath("//span/@class").toString();
            if (StringUtils.compareString(clazz, "current")) {
                currentPosition = i;
                break;
            }
        }
        //如果不是最后一个，后边一个内容不是下一页、尾页，则添加下个的链接到page中
        if (currentPosition < paginationSpans.size() - 1) {
            Selectable spanNode = paginationSpans.get(currentPosition + 1);
            String content = spanNode.xpath("//a/text()").toString();
            if (!StringUtils.compareString(content, "下一页") && !StringUtils.compareString(content, "尾页")) {
                String nextpage = spanNode.xpath("//a/@href").toString();
                page.addTargetRequest(nextpage);
            }
        }
        //解析具体的菜谱box，并将相关的菜谱的url放到page中进行下一步解析
        List<String> urls = new ArrayList<String>();
        List<Selectable> container = page.getHtml().$("#container div.cp_box").nodes();
        if (container != null && !container.isEmpty()) {
            for (Selectable cpBox : container) {
                Selectable cpName = cpBox.$("div.cp_msg a.cp_name");
                String _url = cpName.xpath("//a/@href").toString();
                if (!StringUtils.isNullOrEmpty(_url) && _url.matches("http://www.douguo.com/cookbook/[0-9]{1,8}.html")) {
                    urls.add(_url);
//                    page.addTargetRequest(_url);
                }
            }
        }
        page.addTargetRequests(urls);
    }

    @Override
    public Site getSite() {
        return site;
    }
}