package com.FoodDeliveryApp.Food.delivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @NotBlank
    private String adminName;
    @Pattern(regexp = "^.+@admin\\.com$", message = "Invalid email format")
    private String adminEmail;
    private String adminPassword;
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Invalid phone number format")
    @Size(min = 12, max = 12, message = "Phone number length should be 12 digits")
    private String phoneNumber;
}
