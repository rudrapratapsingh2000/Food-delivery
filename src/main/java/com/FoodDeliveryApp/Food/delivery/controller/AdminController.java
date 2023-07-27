package com.FoodDeliveryApp.Food.delivery.controller;

import com.FoodDeliveryApp.Food.delivery.model.Admin;
import com.FoodDeliveryApp.Food.delivery.model.Food;
import com.FoodDeliveryApp.Food.delivery.model.OrderModel;
import com.FoodDeliveryApp.Food.delivery.service.AdminService;
import com.FoodDeliveryApp.Food.delivery.service.FoodService;
import com.FoodDeliveryApp.Food.delivery.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    FoodService foodService;
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/creat-admin")
    public ResponseEntity addAdmin(@Valid @RequestBody Admin admindetails) {
        return adminService.savedata(admindetails);
    }

    @GetMapping(value = "/getadmin")
    public List<Admin> getAll() {
        return adminService.showAll();
    }

    @PostMapping(value = "/create-food-item")
    public ResponseEntity createfood(@RequestBody Food food) {
        foodService.savefood(food);
        return new ResponseEntity<>("Food Item was created by the Admin", HttpStatus.CREATED);
    }

    @GetMapping(value = "/getallfood")
    public ResponseEntity getallfood() {
        List<Food> foodItems = foodService.getall();
        return new ResponseEntity<>("Admin getting all the foods - " + foodItems, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletefoodbyid")
    public ResponseEntity deletefood(@RequestParam Integer foodId) {
        if (foodService.getfoodbyId(foodId) != null) {
            foodService.deletefood(foodId);
        } else {
            return new ResponseEntity<>("FoodItem with the following id is not present in the database", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("FoodItem is deleted successfully", HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/update-food-details")
    public ResponseEntity updatefood(@RequestParam Integer foodId, @Valid @RequestBody Food foodItem) {
        List<Food> foodItems = adminService.findfoodItems();
        for (Food food : foodItems) {
            if (food.getFoodId() == foodId) {
                food.setName(foodItem.getName());
                food.setDescription(foodItem.getDescription());
                foodService.savefood(food);
                return new ResponseEntity<>("Food data has been updated", HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("Fooditem with the following id has not been found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/getOrderbyorderid")
    public ResponseEntity orderget(@RequestParam Integer orderid) {
        List<OrderModel> orderList = orderService.getall();
        for (OrderModel order : orderList) {
            if (order.getOrderId() == orderid) {
                return new ResponseEntity("order which was given by this order id is -" + order.getFood().getName(), HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("order with the following order id has not been found ", HttpStatus.NOT_FOUND);
    }
}
