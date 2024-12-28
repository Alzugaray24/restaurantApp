package com.example.controllers.review;

import com.example.services.review.AddReviewService;
import com.example.utils.consoleUtils.ConsoleUtils;

public class AddReviewController {
    private final ConsoleUtils console;
    private final AddReviewService addReviewService;

    public AddReviewController(ConsoleUtils console, AddReviewService addReviewService) {
        this.console = console;
        this.addReviewService = addReviewService;
    }

    public void addReviewToDish() {
        try {
            String dishName = console.getString("Ingrese el nombre del plato: ");
            String comment = console.getString("Ingrese su comentario de reseña: ");
            Integer score = console.getInteger("Ingrese su puntuación de reseña: ");

            addReviewService.addReviewToDish(dishName, comment, score);
            System.out.println("Reseña agregada al plato: " + dishName);
        } catch (Exception e) {
            System.out.println("Error al agregar la reseña: " + e.getMessage());
        }
    }

    public void addReviewToRestaurant() {
        try {
            String restaurantName = console.getString("Ingrese el nombre del restaurante: ");
            String comment = console.getString("Ingrese su comentario de reseña: ");
            Integer score = console.getInteger("Ingrese su puntuación de reseña: ");

            addReviewService.addReviewToRestaurant(restaurantName, comment, score);
            System.out.println("Reseña agregada al restaurante: " + restaurantName);
        } catch (Exception e) {
            System.out.println("Error al agregar la reseña: " + e.getMessage());
        }
    }
}