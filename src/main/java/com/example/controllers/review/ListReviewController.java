package com.example.controllers.review;

import com.example.models.Review;
import com.example.services.review.ListReviewService;
import com.example.utils.consoleUtils.ConsoleUtils;

import java.util.List;

public class ListReviewController {
    private final ConsoleUtils console;
    private final ListReviewService listReviewService;

    public ListReviewController(ConsoleUtils console, ListReviewService listReviewService) {
        this.console = console;
        this.listReviewService = listReviewService;
    }

    public void listReviewsForDish() {
        try {
            String dishName = console.getString("Ingrese el nombre del plato: ");
            List<Review> reviews = listReviewService.listReviewsForDish(dishName);
            reviews.forEach(review -> System.out.println("Comentario: " + review.getComment() + ", Puntuación: " + review.getScore()));
        } catch (Exception e) {
            System.out.println("Error al listar las reseñas: " + e.getMessage());
        }
    }

    public void listReviewsForRestaurant() {
        try {
            String restaurantName = console.getString("Ingrese el nombre del restaurante: ");
            List<Review> reviews = listReviewService.listReviewsForRestaurant(restaurantName);
            reviews.forEach(review -> System.out.println("Comentario: " + review.getComment() + ", Puntuación: " + review.getScore()));
        } catch (Exception e) {
            System.out.println("Error al listar las reseñas: " + e.getMessage());
        }
    }
}