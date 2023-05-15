package com.foodwastage.backend.repository;

import com.foodwastage.backend.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import java.util.Optional;

// @Repository
public interface CommunityRepository extends JpaRepository<Community,Integer> {
    Optional<Community> findByCode(String code);
}
