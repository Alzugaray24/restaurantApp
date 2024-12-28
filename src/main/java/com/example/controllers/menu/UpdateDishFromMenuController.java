// src/main/java/com/example/controllers/menu/UpdateDishFromMenuController.java
package com.example.controllers.menu;

import com.example.models.Dish;
import com.example.models.Restaurant;
import com.example.models.Review;
import com.example.services.menu.UpdateDishFromMenuService;
import com.example.utils.consoleUtils.ConsoleUtils;
import com.example.repositories.RestaurantRepository;

import java.util.List;

public class UpdateDishFromMenuController {
    private final UpdateDishFromMenuService updateDishFromMenuService;
    private final ConsoleUtils console;
    private final RestaurantRepository restaurantRepository;

    public UpdateDishFromMenuController(UpdateDishFromMenuService updateDishFromMenuService, ConsoleUtils console, RestaurantRepository restaurantRepository) {
        this.updateDishFromMenuService = updateDishFromMenuService;
        this.console = console;
        this.restaurantRepository = restaurantRepository;
    }

    public void updateDishFromMenu() {
        try {
            Restaurant restaurant = getRestaurant();
            if (restaurant == null) return;

            Dish dish = getDish(restaurant);
            if (dish == null) return;

            Dish updatedDish = getUpdatedDish(dish);
            updateDishInMenu(restaurant, updatedDish);
        } catch (Exception e) {
            System.out.println("Error al actualizar el plato del menú: " + e.getMessage());
        }
    }

    private Restaurant getRestaurant() {
        String restaurantName = console.getString("Ingrese el nombre del restaurante: ");
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        if (restaurant == null) {
            System.out.println("Restaurante no encontrado");
        }
        return restaurant;
    }

    private Dish getDish(Restaurant restaurant) {
        String dishName = console.getString("Ingrese el nombre del plato a actualizar: ");
        Dish dish = restaurant.getMenu().getDishes().stream()
                .filter(d -> d.getName().equals(dishName))
                .findFirst()
                .orElse(null);
        if (dish == null) {
            System.out.println("Plato no encontrado en el menú");
        }
        return dish;
    }

    private Dish getUpdatedDish(Dish dish) {
        String newDescription = console.getString("Ingrese la nueva descripción del plato: ");
        double newPrice = console.getDouble("Ingrese el nuevo precio del plato: ");
        List<Review> existingReviews = dish.getReviews();
        return new Dish(dish.getName(), newDescription, newPrice, existingReviews);
    }

    private void updateDishInMenu(Restaurant restaurant, Dish updatedDish) {
        updateDishFromMenuService.setRestaurant(restaurant);
        updateDishFromMenuService.setUpdatedDish(updatedDish);
        updateDishFromMenuService.execute();
        System.out.println("Plato actualizado en el menú");
    }
}