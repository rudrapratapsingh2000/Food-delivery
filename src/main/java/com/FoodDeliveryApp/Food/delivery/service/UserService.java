package com.FoodDeliveryApp.Food.delivery.service;

import com.FoodDeliveryApp.Food.delivery.model.UserModel;
import com.FoodDeliveryApp.Food.delivery.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    public UserModel addUser(UserModel user) {
        return iUserRepo.save(user);
    }

    public List<UserModel> getall() {
        return iUserRepo.findAll();
    }

    public ResponseEntity login(String name, String email) {
        List<UserModel> userList = iUserRepo.findAll();
        for (UserModel user : userList) {
            if (user.getName().equals(name)) {
                if (user.getEmail().equals(email)) {
                    return new ResponseEntity<>("User login successfully", HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>("please check the user name and email ", HttpStatus.NOT_FOUND);
    }
}
