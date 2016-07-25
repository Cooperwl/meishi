package com.meishi.metadata.ws.food.dto;

public class FoodStepDTO {
    private Long id;

    private Long foodId;

    private Integer sequence;

    private String description;

    private String image;

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", foodId:" + foodId +
                ", sequence:" + sequence +
                ", description:\"" + description + "\"" +
                ", image:\"" + image + "\"" +
                '}';
    }
}