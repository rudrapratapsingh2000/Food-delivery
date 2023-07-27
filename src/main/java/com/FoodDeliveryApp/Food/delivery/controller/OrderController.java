package com.FoodDeliveryApp.Food.delivery.controller;

import com.FoodDeliveryApp.Food.delivery.service.OrderService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/create-order")
    public ResponseEntity<String> createOrder(@RequestBody String orderrequest) {
        return orderService.createOrder(orderrequest);
    }

    @GetMapping(value = "/get-order-by-orderid")
    public ResponseEntity<String> getOrder(@Valid @Nullable @RequestParam String orderId) {
        return orderService.getorder(orderId);
    }
}
