package com.FoodDeliveryApp.Food.delivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Length(min = 3, max = 20, message = "User name should contain characters between 3-20 ")
    private String name;
    @Email(message = "Enter valid email")
    private String email;

}
