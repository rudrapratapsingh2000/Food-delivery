package com.FoodDeliveryApp.Food.delivery.repository;

import com.FoodDeliveryApp.Food.delivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepo extends JpaRepository<Food, Integer> {
}
