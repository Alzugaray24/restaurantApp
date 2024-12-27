package com.example.utils.menuUtils;

import com.example.controllers.restaurant.AddRestaurantController;
import com.example.controllers.restaurant.RemoveRestaurantController;
import com.example.controllers.restaurant.ShowRestaurantsController;
import com.example.utils.consoleUtils.ConsoleUtils;

public class Menu {
    private final AddRestaurantController addRestaurantController;
    private final RemoveRestaurantController removeRestaurantController;
    private final ShowRestaurantsController showRestaurantsController;
    private final ConsoleUtils console;

    public Menu(AddRestaurantController addRestaurantController, RemoveRestaurantController removeRestaurantController, ShowRestaurantsController showRestaurantsController, ConsoleUtils console) {
        this.addRestaurantController = addRestaurantController;
        this.removeRestaurantController = removeRestaurantController;
        this.showRestaurantsController = showRestaurantsController;
        this.console = console;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Agregar Restaurante");
            System.out.println("2. Eliminar Restaurante");
            System.out.println("3. Mostrar Restaurantes");
            System.out.println("0. Salir");
            int choice = console.getInteger("Elige una opción: ");

            switch (choice) {
                case 1 -> addRestaurantController.addRestaurant();
                case 2 -> removeRestaurantController.removeRestaurant();
                case 3 -> showRestaurantsController.showRestaurants();
                case 0 -> exit = true;
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}