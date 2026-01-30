package com.example.foodredistribution.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PickupRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ngoName;
    private int foodId;
    private LocalDateTime requestTime;

    public PickupRequest() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNgoName() { return ngoName; }
    public void setNgoName(String ngoName) { this.ngoName = ngoName; }

    public int getFoodId() { return foodId; }
    public void setFoodId(int foodId) { this.foodId = foodId; }

    public LocalDateTime getRequestTime() { return requestTime; }
    public void setRequestTime(LocalDateTime requestTime) { this.requestTime = requestTime; }
}
