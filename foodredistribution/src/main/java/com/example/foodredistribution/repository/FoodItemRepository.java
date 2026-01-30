package com.example.foodredistribution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.foodredistribution.entity.FoodItem;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByStatus(String status);
}
