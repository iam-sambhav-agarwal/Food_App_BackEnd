package com.sam.Service;

import com.sam.model.Category;
import com.sam.model.Food;
import com.sam.model.Restaurant;
import com.sam.response.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    List<Food> getRestaurantsFood(Long restaurantId,
                                  boolean isVegetarian,
                                  boolean isNonVeg,
                                  boolean isSeasonal,
                                  String foodCategory);

    public List<Food> searchFood(String keyword);

    Food findFoodById(Long foodId) throws Exception;

    Food updateAvailabilityStatus(Long foodId) throws Exception;


}
