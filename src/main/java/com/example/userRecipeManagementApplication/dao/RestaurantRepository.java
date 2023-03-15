package com.example.userRecipeManagementApplication.dao;

import com.example.userRecipeManagementApplication.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
