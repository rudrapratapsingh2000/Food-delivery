package com.FoodDeliveryApp.Food.delivery.repository;

import com.FoodDeliveryApp.Food.delivery.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<UserModel, Integer> {
}
