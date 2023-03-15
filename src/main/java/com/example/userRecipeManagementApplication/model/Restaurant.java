package com.example.userRecipeManagementApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "address")
    private String address;

    @Column(name = "recipe_name_1")
    private String recipeName1;

    @Column(name = "recipe_name_2")
    private String recipeName2;

    @Column(name = "recipe_name_3")
    private String recipeName3;

    @Column(name = "recipe_name_4")
    private String recipeName4;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
