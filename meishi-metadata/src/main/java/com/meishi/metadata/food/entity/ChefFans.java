package com.meishi.metadata.food.entity;

public class ChefFans {
    private Long id;

    private Long chefId;

    private Long fanChefId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
        this.chefId = chefId;
    }

    public Long getFanChefId() {
        return fanChefId;
    }

    public void setFanChefId(Long fanChefId) {
        this.fanChefId = fanChefId;
    }
}