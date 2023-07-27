package com.FoodDeliveryApp.Food.delivery.repository;

import com.FoodDeliveryApp.Food.delivery.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<OrderModel, Integer> {
}
