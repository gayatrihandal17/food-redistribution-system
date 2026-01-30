package com.example.foodredistribution.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import com.example.foodredistribution.entity.FoodItem;
import com.example.foodredistribution.entity.PickupRequest;
import com.example.foodredistribution.repository.FoodItemRepository;
import com.example.foodredistribution.repository.PickupRequestRepository;

@Service
public class FoodService {

    private final FoodItemRepository foodRepo;
    private final PickupRequestRepository pickupRepo;

    public FoodService(FoodItemRepository foodRepo, PickupRequestRepository pickupRepo) {
        this.foodRepo = foodRepo;
        this.pickupRepo = pickupRepo;
    }

    public FoodItem addFood(FoodItem food) {
        food.setStatus("AVAILABLE");
        return foodRepo.save(food);
    }

    public List<FoodItem> getAvailableFood() {
        return foodRepo.findByStatus("AVAILABLE");
    }

    public PickupRequest requestPickup(String ngoName, int foodId) {
        FoodItem food = foodRepo.findById(foodId).orElseThrow();
        food.setStatus("REQUESTED");
        foodRepo.save(food);

        PickupRequest pr = new PickupRequest();
        pr.setNgoName(ngoName);
        pr.setFoodId(foodId);
        pr.setRequestTime(LocalDateTime.now());

        return pickupRepo.save(pr);
    }

    public void markExpired() {
        List<FoodItem> all = foodRepo.findAll();
        for (FoodItem f : all) {
            if (f.getExpiryTime().isBefore(LocalDateTime.now())) {
                f.setStatus("EXPIRED");
                foodRepo.save(f);
            }
        }
    }
}
