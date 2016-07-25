package com.meishi.ws.dto;

public class FoodMaterialDTO {
    private Long id;

    private Long foodId;

    private Long materialId;

    private String materialName;

    private String usedAmount;

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

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

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(String usedAmount) {
        this.usedAmount = usedAmount == null ? null : usedAmount.trim();
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", foodId:" + foodId +
                ", materialId:" + materialId +
                ", materialName:\"" + materialName + "\"" +
                ", usedAmount:\"" + usedAmount + "\"" +
                '}';
    }
}