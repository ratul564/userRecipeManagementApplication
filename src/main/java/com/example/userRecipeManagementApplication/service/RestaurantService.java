package com.example.userRecipeManagementApplication.service;

import com.example.userRecipeManagementApplication.dao.RestaurantRepository;
import com.example.userRecipeManagementApplication.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public int addRecipe(Restaurant recipe) {
        Restaurant restaurantObj = restaurantRepository.save(recipe);
        return restaurantObj.getRestaurantId();
    }

    public List<Restaurant> getRecipes(String restaurantId) {
        List<Restaurant> recipeList;

        if(null!=restaurantId){
            recipeList = new ArrayList<>();
            recipeList.add(restaurantRepository.findById(Integer.valueOf(restaurantId)).get());
        }
        else{
            recipeList = restaurantRepository.findAll();
        }
        return recipeList;
    }
    public void updateRecipe(int restaurantId, Restaurant newRecipe) {

        Restaurant recipe = restaurantRepository.findById(restaurantId).get();

        recipe.setRestaurantName(newRecipe.getRestaurantName());
        recipe.setAddress(newRecipe.getAddress());
        recipe.setRecipeName1(newRecipe.getRecipeName1());
        recipe.setRecipeName2(newRecipe.getRecipeName2());
        recipe.setRecipeName3(newRecipe.getRecipeName3());
        recipe.setRecipeName4(newRecipe.getRecipeName4());
        recipe.setEmail(newRecipe.getEmail());
        recipe.setPhoneNumber(newRecipe.getPhoneNumber());

        restaurantRepository.save(recipe);

    }
    public void deleteRecipe(int restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}
