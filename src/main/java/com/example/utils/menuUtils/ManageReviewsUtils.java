package com.example.utils.menuUtils;

import com.example.controllers.review.AddReviewController;
import com.example.controllers.review.ListReviewController;
import com.example.controllers.review.CalculateAverageRatingController;
import com.example.utils.consoleUtils.ConsoleUtils;

public class ManageReviewsUtils {
    private final AddReviewController addReviewController;
    private final ListReviewController listReviewController;
    private final CalculateAverageRatingController calculateAverageRatingController;
    private final ConsoleUtils console;

    public ManageReviewsUtils(AddReviewController addReviewController, ListReviewController listReviewController, CalculateAverageRatingController calculateAverageRatingController, ConsoleUtils console) {
        this.addReviewController = addReviewController;
        this.listReviewController = listReviewController;
        this.calculateAverageRatingController = calculateAverageRatingController;
        this.console = console;
    }

    public void manageReviews() {
        System.out.println("Opciones de Reseñas:");
        System.out.println("1. Agregar Reseña a Plato");
        System.out.println("2. Agregar Reseña a Restaurante");
        System.out.println("3. Listar Reseñas de Plato");
        System.out.println("4. Listar Reseñas de Restaurante");
        System.out.println("5. Calcular Calificación Promedio de Plato");
        System.out.println("6. Calcular Calificación Promedio de Restaurante");
        System.out.println("0. Volver");
        int reviewChoice = console.getInteger("Elige una opción: ");
        switch (reviewChoice) {
            case 1 -> addReviewController.addReviewToDish();
            case 2 -> addReviewController.addReviewToRestaurant();
            case 3 -> listReviewController.listReviewsForDish();
            case 4 -> listReviewController.listReviewsForRestaurant();
            case 5 -> calculateAverageRatingController.calculateAverageRatingForDish();
            case 6 -> calculateAverageRatingController.calculateAverageRatingForRestaurant();
            case 0 -> {
            }
            default -> System.out.println("Opción no válida.");
        }
    }
}