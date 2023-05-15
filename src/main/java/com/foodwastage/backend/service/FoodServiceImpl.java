package com.foodwastage.backend.service;

import com.foodwastage.backend.model.Food;
import com.foodwastage.backend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    public FoodRepository foodRepository;
    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Page<Food> getFoodPaginationByName(String name,int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return foodRepository.findByName(name,pageable);
    }

    @Override
    public Page<Food> getFoodPaginationByDate(String date, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return foodRepository.findByDate(date,pageable);
    }

    @Override
    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }


}
