package com.example.utils.menuUtils;

import com.example.utils.consoleUtils.ConsoleUtils;

public class MainMenuUtils {
    private final RestaurantMenuUtils restaurantMenuUtils;
    private final ManageMenuUtils manageMenuUtils;
    private final ManageReviewsUtils manageReviewsUtils;
    private final ConsoleUtils console;

    public MainMenuUtils(RestaurantMenuUtils restaurantMenuUtils, ManageMenuUtils manageMenuUtils, ManageReviewsUtils manageReviewsUtils, ConsoleUtils console) {
        this.restaurantMenuUtils = restaurantMenuUtils;
        this.manageMenuUtils = manageMenuUtils;
        this.manageReviewsUtils = manageReviewsUtils;
        this.console = console;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Gestionar Restaurantes");
            System.out.println("2. Gestionar Menú");
            System.out.println("3. Gestionar Reseñas");
            System.out.println("0. Salir");
            int choice = console.getInteger("Elige una opción: ");

            switch (choice) {
                case 1 -> restaurantMenuUtils.showMenu();
                case 2 -> manageMenuUtils.manageMenu();
                case 3 -> manageReviewsUtils.manageReviews();
                case 0 -> exit = true;
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}