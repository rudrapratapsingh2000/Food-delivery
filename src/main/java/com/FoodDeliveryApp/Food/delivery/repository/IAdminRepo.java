package com.FoodDeliveryApp.Food.delivery.repository;

import com.FoodDeliveryApp.Food.delivery.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Long> {
}
