package com.FoodDeliveryApp.Food.delivery.service;

import com.FoodDeliveryApp.Food.delivery.model.Food;
import com.FoodDeliveryApp.Food.delivery.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo iFoodRepo;

    public Food savefood(Food food) {
        return iFoodRepo.save(food);
    }

    public List<Food> getall() {
        return iFoodRepo.findAll();
    }

    public Food getfoodbyId(Integer foodId) {
        return iFoodRepo.findById(foodId).get();
    }

    public void deletefood(Integer foodId) {
        iFoodRepo.deleteById(foodId);
    }

    public void updatefood(Integer foodid, Food foodItem) {
        Food food = getfoodbyId(foodid);
        food.setName(foodItem.getName());
        food.setDescription(foodItem.getDescription());
    }
}
