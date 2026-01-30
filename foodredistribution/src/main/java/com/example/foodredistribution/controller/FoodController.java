package com.example.foodredistribution.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.foodredistribution.entity.FoodItem;
import com.example.foodredistribution.entity.PickupRequest;
import com.example.foodredistribution.service.FoodService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FoodController {

    private final FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    @PostMapping("/food")
    public FoodItem addFood(@RequestBody FoodItem food){
        return service.addFood(food);
    }

    @GetMapping("/food")
    public List<FoodItem> getFood(){
        return service.getAvailableFood();
    }

    @PostMapping("/pickup/{foodId}")
    public PickupRequest pickup(@PathVariable int foodId,
                                @RequestParam String ngoName){
        return service.requestPickup(ngoName, foodId);
    }
}
