package com.externshipproject.FoodOrderingSystemTeam110.model;

import java.util.List;

public class CreateOrderRequest {
    private Long userId;
    private List<Long> foodItemIds;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(Long userId, List<Long> foodItemIds) {
        this.userId = userId;
        this.foodItemIds = foodItemIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getFoodItemIds() {
        return foodItemIds;
    }

    public void setFoodItemIds(List<Long> foodItemIds) {
        this.foodItemIds = foodItemIds;
    }
}
