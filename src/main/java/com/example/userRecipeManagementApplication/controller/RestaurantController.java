package com.example.userRecipeManagementApplication.controller;

import com.example.userRecipeManagementApplication.model.Restaurant;
import com.example.userRecipeManagementApplication.service.RestaurantService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping(value = "/add-recipe")
    public ResponseEntity<String> addRecipe(@RequestBody String userData){


        JSONObject isRequestValid = validateUserRequest(userData);

        Restaurant recipe = null;

        if(isRequestValid.isEmpty()){
            recipe = setRecipe(userData);
            restaurantService.addRecipe(recipe);
        }
        else{
            new ResponseEntity<String>(isRequestValid.toString(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Saved",HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-recipes")
    public List<Restaurant> getRecipes(@Nullable @RequestParam String restaurantId){
        return restaurantService.getRecipes(restaurantId);
    }

    @PutMapping(value = "/update-restaurant/{restaurantId}")
    public void updateRestaurant(@PathVariable int restaurantId,@RequestBody Restaurant recipe){
        restaurantService.updateRecipe(restaurantId,recipe);
    }

    @DeleteMapping(value = "/delete-restaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable int restaurantId){
        restaurantService.deleteRecipe(restaurantId);
    }

    private Restaurant setRecipe(String userData) {

         Restaurant recipe = new Restaurant();
         JSONObject json = new JSONObject(userData);

         recipe.setRestaurantName(json.getString("restaurantName"));
         recipe.setPhoneNumber(json.getString("phoneNumber"));
         recipe.setEmail(json.getString("email"));

         if(json.has("address")){
             recipe.setAddress(json.getString("address"));
         }

        if(json.has("recipeName1")){
            recipe.setAddress(json.getString("recipeName1"));
        }

        if(json.has("recipeName2")){
            recipe.setAddress(json.getString("recipeName2"));
        }

        if(json.has("recipeName3")){
            recipe.setAddress(json.getString("recipeName3"));
        }

        if(json.has("recipeName4")){
            recipe.setAddress(json.getString("recipeName5"));
        }
        return recipe;
    }

    private JSONObject validateUserRequest(String userData) {

        JSONObject restaurantJson = new JSONObject(userData);

        JSONObject errorList = new JSONObject();

        if(restaurantJson.has("restaurantName")){
           String restaurantName = restaurantJson.getString("restaurantName");
        }
        else{
            errorList.put("restaurantName","Missing parameter");
        }

        if(restaurantJson.has("phoneNumber")){
            String phoneNumber = restaurantJson.getString("phoneNumber");
        }
        else{
            errorList.put("phoneNumber","Missing parameter");
        }

        if(restaurantJson.has("email")){
            String email = restaurantJson.getString("email");
        }
        else{
            errorList.put("email","Missing parameter");
        }
        return errorList;
    }

}
