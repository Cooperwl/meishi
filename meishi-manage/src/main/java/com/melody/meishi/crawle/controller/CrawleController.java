package com.melody.meishi.crawle.controller;

import com.melody.meishi.crawle.pipline.DouguoPipline;
import com.melody.meishi.crawle.processor.DouguoProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import us.codecraft.webmagic.Spider;

/**
 * Created by Cooper on 2015/8/31.
 */
@Controller
@RequestMapping(value = "/crawle")
public class CrawleController {

    private static final String PROPERTIES_FILE_NAME = "table.properties";

    @Autowired
    private DouguoPipline pipeline;

    @RequestMapping("/run")
    public void crawleChuancai(String table){

//        if (StringUtils.isNullOrEmpty(table)){
//            return;
//        }
//        String type = ReadProperties.getProperty(table,PROPERTIES_FILE_NAME);
//        if (StringUtil.isNullOrEmpty(type)){
//            return;
//        }
//

//        meishiService.batchSaveMeishi(new ArrayList<MeishiDTO>());

    }

    public static void main(String[] args) {
        DouguoPipline pipeline = new DouguoPipline("家常菜");
        Spider.create(new DouguoProcessor("http://www.douguo.com/","家常菜"))
                .addUrl("http://www.douguo.com/caipu/家常菜/")
                .addPipeline(pipeline)
                .thread(10)//此处线程数可调节
                .run();
    }
}
