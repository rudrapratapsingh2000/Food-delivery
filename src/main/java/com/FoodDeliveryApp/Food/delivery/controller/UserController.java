package com.FoodDeliveryApp.Food.delivery.controller;

import com.FoodDeliveryApp.Food.delivery.model.UserModel;
import com.FoodDeliveryApp.Food.delivery.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/create-user")
    public UserModel saveuser(@Valid @RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @GetMapping(value = "/getallUsers")
    public List<UserModel> getall() {
        return userService.getall();
    }

    @GetMapping(value = "/login")
    public ResponseEntity login(@RequestParam String name, @RequestParam String email) {
        return userService.login(name, email);
    }
}
