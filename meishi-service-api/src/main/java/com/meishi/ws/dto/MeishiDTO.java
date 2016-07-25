package com.meishi.ws.dto;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class MeishiDTO {

    private String meishiId;//ID
    private String title;//标题
    private String picture;//图片
    private String material;//材料
    private List<CookStepDTO> cookSteps;//步骤
    private String tips;//说明

    public String getMeishiId() {
        return meishiId;
    }

    public void setMeishiId(String meishiId) {
        this.meishiId = meishiId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public List<CookStepDTO> getCookSteps() {
        return cookSteps;
    }

    public void setCookSteps(List<CookStepDTO> cookSteps) {
        this.cookSteps = cookSteps;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
    @Override
    public String toString() {

        return "{" +
                "id='" + meishiId + '\'' +
                ",title='" + title + '\'' +
                ", imgUrl='" + picture + '\'' +
                ", material='" + material + '\'' +
                ", steps=" + cookSteps.toString() +
                ", tips='" + tips + '\'' +
                '}';
    }
}
