package com.sam.controller;


import com.sam.Service.FoodService;
import com.sam.Service.RestaurantService;
import com.sam.Service.UserService;
import com.sam.model.Food;
import com.sam.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String Name,
                                                 @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Food> foods = foodService.searchFood(Name);

        return new ResponseEntity<>(foods, HttpStatus.CREATED);

    }


    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam boolean Veg,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonVeg,
            @RequestParam(required = false) String food_category,
            @PathVariable Long restaurantId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Food> foods = foodService.getRestaurantsFood(restaurantId, Veg, seasonal, nonVeg, food_category);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

}