package com.sam.Service;

import com.sam.model.Category;

import java.util.List;

public interface CategoryService {


    Category createCategory(String name, Long userId) throws Exception;

    List<Category> findCategoryByRestaurantId(Long userId) throws Exception;

    Category findCategoryById(Long id) throws Exception;

}
