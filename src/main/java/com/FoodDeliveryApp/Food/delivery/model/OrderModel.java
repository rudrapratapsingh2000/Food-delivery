package com.FoodDeliveryApp.Food.delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @OneToOne
    @JoinColumn(name = "fk_food_id")
    Food food;
    @ManyToOne(fetch = FetchType.LAZY)
    UserModel userModel;
}
