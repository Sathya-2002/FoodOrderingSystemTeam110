package com.externshipproject.FoodOrderingSystemTeam110.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;
import com.externshipproject.FoodOrderingSystemTeam110.repository.FoodItemRepository;

import java.util.List;
import java.util.Optional;


@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

//    @Autowired
//    public FoodItemService(FoodItemRepository foodItemRepository) {
//        this.foodItemRepository = foodItemRepository;
//    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> getFoodItemById(Long id) {
        return foodItemRepository.findById(id);
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public void deleteFoodItemById(Long id) {
        foodItemRepository.deleteById(id);
    }

	public List<FoodItem> getFoodItemsByName(String name) {
		return foodItemRepository.findByName(name);
	}

    public FoodItem findFoodItemById(Long foodItemId) {
        Optional<FoodItem> optionalFoodItem = foodItemRepository.findById(foodItemId);
        return optionalFoodItem.get();
    }

}
