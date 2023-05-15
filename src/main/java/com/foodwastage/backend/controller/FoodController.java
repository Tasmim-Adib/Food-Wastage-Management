package com.foodwastage.backend.controller;

import com.foodwastage.backend.model.Food;
import com.foodwastage.backend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class FoodController {
    @Autowired
    public FoodService foodService;

    @PostMapping("/food/add")
    public String add(@RequestBody Food food){
        foodService.saveFood(food);
        return "new Food Added";
    }

    @GetMapping("/food/name/{name}/{pageNo}/{pageSize}")
    public Page<Food> getFoodByName(@PathVariable String name,@PathVariable int pageNo, @PathVariable int pageSize){
        return foodService.getFoodPaginationByName(name,pageNo,pageSize);
    }

    @GetMapping("/food/date/{date}/{pageNo}/{pageSize}")
    public Page<Food> getFoodByDate(@PathVariable String date,@PathVariable int pageNo, @PathVariable int pageSize){
        return foodService.getFoodPaginationByDate(date,pageNo,pageSize);
    }

    @PutMapping("/food/update/{id}")
    public Food updateFood(@PathVariable int id, @RequestBody Food food){
        food.setId(id);
        return foodService.updateFood(food);
    }
}
