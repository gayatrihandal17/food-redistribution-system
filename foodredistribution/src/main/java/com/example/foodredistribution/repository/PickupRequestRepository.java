package com.example.foodredistribution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.foodredistribution.entity.PickupRequest;

public interface PickupRequestRepository extends JpaRepository<PickupRequest, Integer> {
}
