package com.FoodDeliveryApp.Food.delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;
    @Length(min = 3, max = 10, message = "please enter the Food name with the length of 3 - 10")
    private String name;
    @Length(min = 3, max = 60, message = "please enter the Food description length between 3 to 60 characters")
    private String description;
}
