package com.example.utils.menuUtils;

import com.example.controllers.menu.AddDishToMenuController;
import com.example.controllers.menu.RemoveDishFromMenuController;
import com.example.controllers.menu.UpdateDishFromMenuController;
import com.example.controllers.restaurant.AddRestaurantController;
import com.example.controllers.restaurant.RemoveRestaurantController;
import com.example.controllers.restaurant.ShowRestaurantsController;
import com.example.controllers.restaurant.UpdateRestaurantController;
import com.example.controllers.review.AddReviewController;
import com.example.controllers.review.ListReviewController;
import com.example.controllers.review.CalculateAverageRatingController;
import com.example.utils.consoleUtils.ConsoleUtils;

public class Menu {
    private final AddRestaurantController addRestaurantController;
    private final RemoveRestaurantController removeRestaurantController;
    private final ShowRestaurantsController showRestaurantsController;
    private final UpdateRestaurantController updateRestaurantController;
    private final AddDishToMenuController addDishToMenuController;
    private final RemoveDishFromMenuController removeDishFromMenuController;
    private final UpdateDishFromMenuController updateDishFromMenuController;
    private final AddReviewController addReviewController;
    private final ListReviewController listReviewController;
    private final CalculateAverageRatingController calculateAverageRatingController;
    private final ConsoleUtils console;

    public Menu(AddRestaurantController addRestaurantController, RemoveRestaurantController removeRestaurantController, ShowRestaurantsController showRestaurantsController, UpdateRestaurantController updateRestaurantController, AddDishToMenuController addDishToMenuController, RemoveDishFromMenuController removeDishFromMenuController, UpdateDishFromMenuController updateDishFromMenuController, AddReviewController addReviewController, ListReviewController listReviewController, CalculateAverageRatingController calculateAverageRatingController, ConsoleUtils console) {
        this.addRestaurantController = addRestaurantController;
        this.removeRestaurantController = removeRestaurantController;
        this.showRestaurantsController = showRestaurantsController;
        this.updateRestaurantController = updateRestaurantController;
        this.addDishToMenuController = addDishToMenuController;
        this.removeDishFromMenuController = removeDishFromMenuController;
        this.updateDishFromMenuController = updateDishFromMenuController;
        this.addReviewController = addReviewController;
        this.listReviewController = listReviewController;
        this.calculateAverageRatingController = calculateAverageRatingController;
        this.console = console;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Agregar Restaurante");
            System.out.println("2. Eliminar Restaurante");
            System.out.println("3. Mostrar Restaurantes");
            System.out.println("4. Actualizar Restaurante");
            System.out.println("5. Gestionar Menú");
            System.out.println("6. Gestionar Reseñas");
            System.out.println("0. Salir");
            int choice = console.getInteger("Elige una opción: ");

            switch (choice) {
                case 1 -> addRestaurantController.addRestaurant();
                case 2 -> removeRestaurantController.removeRestaurant();
                case 3 -> showRestaurantsController.showRestaurants();
                case 4 -> updateRestaurantController.updateRestaurant();
                case 5 -> manageMenu();
                case 6 -> manageReviews();
                case 0 -> exit = true;
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    private void manageMenu() {
        System.out.println("Opciones del Menú:");
        System.out.println("1. Agregar Plato");
        System.out.println("2. Eliminar Plato");
        System.out.println("3. Actualizar Plato");
        int menuChoice = console.getInteger("Elige una opción: ");
        switch (menuChoice) {
            case 1 -> addDishToMenuController.addDishToMenu();
            case 2 -> removeDishFromMenuController.removeDishFromMenu();
            case 3 -> updateDishFromMenuController.updateDishFromMenu();
            default -> System.out.println("Opción no válida.");
        }
    }

    private void manageReviews() {
        System.out.println("Opciones de Reseñas:");
        System.out.println("1. Agregar Reseña a Plato");
        System.out.println("2. Agregar Reseña a Restaurante");
        System.out.println("3. Listar Reseñas de Plato");
        System.out.println("4. Listar Reseñas de Restaurante");
        System.out.println("5. Calcular Calificación Promedio de Plato");
        System.out.println("6. Calcular Calificación Promedio de Restaurante");
        int reviewChoice = console.getInteger("Elige una opción: ");
        switch (reviewChoice) {
            case 1 -> addReviewController.addReviewToDish();
            case 2 -> addReviewController.addReviewToRestaurant();
            case 3 -> listReviewController.listReviewsForDish();
            case 4 -> listReviewController.listReviewsForRestaurant();
            case 5 -> calculateAverageRatingController.calculateAverageRatingForDish();
            case 6 -> calculateAverageRatingController.calculateAverageRatingForRestaurant();
            default -> System.out.println("Opción no válida.");
        }
    }
}