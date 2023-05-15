package com.foodwastage.backend.repository;

import com.foodwastage.backend.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;


// @Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    Page<Food> findByName(String name, Pageable pageable);
    Page<Food> findByDate(String date, Pageable pageable);
}
