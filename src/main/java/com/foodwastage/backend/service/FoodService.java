package com.foodwastage.backend.service;

import com.foodwastage.backend.model.Food;
import org.springframework.data.domain.Page;

// import java.util.List;

public interface FoodService {
    public Food saveFood(Food food);

    Page<Food> getFoodPaginationByName(String name,int pageNo, int pageSize);
    Page<Food> getFoodPaginationByDate(String date,int pageNo, int pageSize);
    Food updateFood(Food food);

}
