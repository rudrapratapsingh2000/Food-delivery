package com.FoodDeliveryApp.Food.delivery.service;

import com.FoodDeliveryApp.Food.delivery.model.Admin;
import com.FoodDeliveryApp.Food.delivery.model.Food;
import com.FoodDeliveryApp.Food.delivery.repository.IAdminRepo;
import com.FoodDeliveryApp.Food.delivery.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    IAdminRepo iAdminRepo;
    @Autowired
    IFoodRepo iFoodRepo;

    public ResponseEntity savedata(Admin admindetails) {
        iAdminRepo.save(admindetails);
        return new ResponseEntity<>("Save data", HttpStatus.CREATED);
    }

    public List<Admin> showAll() {
        return iAdminRepo.findAll();
    }

    public List<Food> findfoodItems() {
        return iFoodRepo.findAll();
    }
}
