package com.sam.controller;

import com.sam.Service.FoodService;
import com.sam.Service.RestaurantService;
import com.sam.Service.UserService;
import com.sam.model.Food;
import com.sam.model.Restaurant;
import com.sam.model.User;
import com.sam.request.CreateFoodRequest;
import com.sam.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(), restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("Food deleted successfully");


        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Food> updateFoodAvailabilityStatus(@PathVariable Long id,
                                                             @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Food food = foodService.updateAvailabilityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }
}
