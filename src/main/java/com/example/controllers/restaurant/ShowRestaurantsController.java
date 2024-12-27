package com.example.controllers.restaurant;

import com.example.models.Restaurant;
import com.example.services.restaurant.ShowRestaurantService;
import com.example.utils.consoleUtils.ConsoleUtils;

import java.util.List;

public class ShowRestaurantsController {
    private final ShowRestaurantService showRestaurantService;

    public ShowRestaurantsController(ShowRestaurantService showRestaurantService, ConsoleUtils console) {
        this.showRestaurantService = showRestaurantService;
    }

    public void showRestaurants() {
        try {
            List<Restaurant> restaurants = showRestaurantService.execute();
            if (restaurants.isEmpty()) {
                System.out.println("No hay restaurantes disponibles.");
            } else {
                System.out.println("Lista de restaurantes:");
                for (Restaurant restaurant : restaurants) {
                    System.out.println("Nombre: " + restaurant.getName() + ", Teléfono: " + restaurant.getPhone() + ", Dirección: " + restaurant.getAddress() + ", Disponibilidad: " + restaurant.getAvailable());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar los restaurantes: " + e.getMessage());
        }
    }
}