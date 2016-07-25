package com.meishi.entity;

public class FoodMaterial {
    private Long id;

    private Long foodId;

    private byte[] materialId;

    private String usedAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public byte[] getMaterialId() {
        return materialId;
    }

    public void setMaterialId(byte[] materialId) {
        this.materialId = materialId;
    }

    public String getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(String usedAmount) {
        this.usedAmount = usedAmount == null ? null : usedAmount.trim();
    }
}