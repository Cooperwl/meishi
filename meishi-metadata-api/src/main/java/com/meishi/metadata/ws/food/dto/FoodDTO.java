package com.meishi.metadata.ws.food.dto;

import com.meishi.common.util.DateUtils;

import java.util.Date;
import java.util.List;

public class FoodDTO {

    private Long id;

    private Integer catId;//类型

    private Long chefId;//用户ID

    private String title;//标题

    private String subTitle;//副标题

    private String description;//描述(小提示tips)

    private String mainPic;//图片

    private Date createDate;//创建时间

    private List<FoodMaterialDTO> materials;//材料

    private List<FoodStepDTO> foodSteps;//步骤

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FoodMaterialDTO> getMaterials() {
        return materials;
    }

    public void setMaterials(List<FoodMaterialDTO> materials) {
        this.materials = materials;
    }

    public List<FoodStepDTO> getFoodSteps() {
        return foodSteps;
    }

    public void setFoodSteps(List<FoodStepDTO> foodSteps) {
        this.foodSteps = foodSteps;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
        this.chefId = chefId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic == null ? null : mainPic.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", catId:" + catId +
                ", chefId:" + chefId +
                ", title:\"" + title + "\"" +
                ", description:\"" + description + "\"" +
                ", mainPic:\"" + mainPic + "\"" +
                ", createDate:\"" + DateUtils.format(createDate) + "\"" +
                ", materials:" + materials +
                ", foodSteps:" + foodSteps +
                '}';
    }
}