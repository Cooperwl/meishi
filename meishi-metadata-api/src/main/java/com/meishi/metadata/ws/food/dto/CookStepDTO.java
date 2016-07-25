package com.meishi.metadata.ws.food.dto;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class CookStepDTO {
    private String meishiId;
    private int stepNum;
    private String stepImg;
    private String stepMethod;

    public String getMeishiId() {
        return meishiId;
    }

    public void setMeishiId(String meishiId) {
        this.meishiId = meishiId;
    }

    public int getStepNum() {
        return stepNum;
    }

    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }

    public String getStepImg() {
        return stepImg;
    }

    public void setStepImg(String stepImg) {
        this.stepImg = stepImg;
    }

    public String getStepMethod() {
        return stepMethod;
    }

    public void setStepMethod(String stepMethod) {
        this.stepMethod = stepMethod;
    }

    @Override
    public String toString() {
        return "{" +
                "meishiId='" + meishiId + '\'' +
                ", stepNum='" + stepNum + '\'' +
                ", stepMethod='" + stepMethod + '\'' +
                ", stepImg='" + stepImg + '\'' +
                '}';
    }
}