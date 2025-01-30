package com.sam.controller;


import com.sam.Service.IngredientsService;
import com.sam.model.IngredientCategory;
import com.sam.model.IngredientsItem;
import com.sam.request.IngredientCategoryRequest;
import com.sam.request.IngredientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {

    @Autowired
    private IngredientsService ingredientsService;


    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> createIngredientCategory(
            @RequestBody IngredientCategoryRequest req) throws Exception {

        IngredientCategory item = ingredientsService.createIngredientCategory(req.getName(), req.getRestaurantId());

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<IngredientsItem> createIngredientItem(
            @RequestBody IngredientRequest req) throws Exception {

        IngredientsItem item = ingredientsService.createIngredientItem(req.getRestaurantId(), req.getName(), req.getCategoryId());

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }


    @PutMapping("/{id}/stoke")
    public ResponseEntity<IngredientsItem> updateIngredientStock(
            @PathVariable Long id) throws Exception {

        IngredientsItem item = ingredientsService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }


    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>> getRestaurantIngredient(
            @PathVariable Long id) throws Exception {

        List<IngredientsItem> item = ingredientsService.findRestaurantsIngredients(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(
            @PathVariable Long id) throws Exception {

        List<IngredientCategory> item = ingredientsService.findIngredientCategoryByRestaurantId(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }


}
