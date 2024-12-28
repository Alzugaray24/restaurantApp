package com.example.controllers.review;

import com.example.services.review.CalculateAverageRatingService;
import com.example.utils.consoleUtils.ConsoleUtils;

public class CalculateAverageRatingController {
    private final ConsoleUtils console;
    private final CalculateAverageRatingService calculateAverageRatingService;

    public CalculateAverageRatingController(ConsoleUtils console, CalculateAverageRatingService calculateAverageRatingService) {
        this.console = console;
        this.calculateAverageRatingService = calculateAverageRatingService;
    }

    public void calculateAverageRatingForDish() {
        try {
            String dishName = console.getString("Ingrese el nombre del plato: ");
            double averageRating = calculateAverageRatingService.calculateAverageRatingForDish(dishName);
            System.out.println("Calificación promedio para el plato " + dishName + ": " + averageRating);
        } catch (Exception e) {
            System.out.println("Error al calcular la calificación promedio: " + e.getMessage());
        }
    }

    public void calculateAverageRatingForRestaurant() {
        try {
            String restaurantName = console.getString("Ingrese el nombre del restaurante: ");
            double averageRating = calculateAverageRatingService.calculateAverageRatingForRestaurant(restaurantName);
            System.out.println("Calificación promedio para el restaurante " + restaurantName + ": " + averageRating);
        } catch (Exception e) {
            System.out.println("Error al calcular la calificación promedio: " + e.getMessage());
        }
    }
}