package com.example.controllers.restaurant;

import com.example.models.Dish;
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
                StringBuilder sb = new StringBuilder();
                for (Restaurant restaurant : restaurants) {
                    printRestaurantDetails(sb, restaurant);
                }
                System.out.println(sb.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar los restaurantes: " + e.getMessage());
        }
    }

    private void printRestaurantDetails(StringBuilder sb, Restaurant restaurant) {
        sb.append("Nombre: ").append(restaurant.getName()).append("\n");
        sb.append("Teléfono: ").append(restaurant.getPhone()).append("\n");
        sb.append("Dirección: ").append(restaurant.getAddress()).append("\n");
        sb.append("Disponibilidad: ").append(restaurant.getAvailable()).append("\n");
        printMenuDetails(sb, restaurant);
        printReviewDetails(sb, restaurant);
        sb.append("Calificación: ").append(restaurant.getRaiting()).append("\n");
        sb.append("-----------------------------\n");
    }

    private void printMenuDetails(StringBuilder sb, Restaurant restaurant) {
        if (restaurant.getMenu() == null) {
            sb.append("Menú: No disponible\n");
        } else {
            sb.append("Menú: ").append(restaurant.getMenu().getDishes().size()).append(" platos\n");
            for (Dish dish : restaurant.getMenu().getDishes()) {
                sb.append("  - Plato: ").append(dish.getName())
                        .append(", Descripción: ").append(dish.getDescription())
                        .append(", Precio: ").append(dish.getPrice()).append("\n");
            }
        }
    }

    private void printReviewDetails(StringBuilder sb, Restaurant restaurant) {
        if (restaurant.getReviews() == null || restaurant.getReviews().isEmpty()) {
            sb.append("Reseñas: No disponibles\n");
        } else {
            sb.append("Reseñas: ").append(restaurant.getReviews().size()).append(" reseñas\n");
        }
    }
}