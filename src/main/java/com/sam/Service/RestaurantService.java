package com.sam.Service;

import com.sam.dto.RestaurantDto;
import com.sam.model.Restaurant;
import com.sam.model.User;
import com.sam.request.CreateRestaurantRequest;

import java.util.List;


public interface RestaurantService {

    Restaurant createRestaurant(CreateRestaurantRequest req, User user);

    Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception;

    void deleteRestaurant(Long restaurantId) throws Exception;

    List<Restaurant> getAllRestaurants();

    List<Restaurant> searchRestaurant(String Keyword);

    Restaurant findRestaurantById(Long restaurantId) throws Exception;

    Restaurant getRestaurantByUserId(Long userId) throws Exception;

    RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception;

    Restaurant updateRestaurantStatus(Long id) throws Exception;
}