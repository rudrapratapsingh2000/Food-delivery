package com.FoodDeliveryApp.Food.delivery.controller;

import com.FoodDeliveryApp.Food.delivery.model.Food;
import com.FoodDeliveryApp.Food.delivery.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping(value="/create-food_item")
    public Food savefood(@Valid @RequestBody Food food){
        return foodService.savefood(food);
    }
    @GetMapping(value = "/getAllfoodItems")
    public List<Food> getallfood(){
        return foodService.getall();
    }
    @GetMapping(value = "/getfoodbyId")
    public Food getbyid(@RequestParam Integer foodid){
        return foodService.getfoodbyId(foodid);
    }
    @DeleteMapping(value = "/delete-food-by-id")
    public ResponseEntity deletebyid(@RequestParam Integer foodid){
        foodService.deletefood(foodid);
        return new ResponseEntity<>("Food item is deleted successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/update-food-item/{foodid}")
    public ResponseEntity updatefood(@PathVariable Integer foodid,@RequestBody Food foodItem){
        foodService.updatefood(foodid,foodItem);
        return new ResponseEntity<>("Update the food item", HttpStatus.ACCEPTED);
    }
}
