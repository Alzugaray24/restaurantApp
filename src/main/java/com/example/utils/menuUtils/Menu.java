// src/main/java/com/example/utils/menuUtils/Menu.java
package com.example.utils.menuUtils;

import com.example.controllers.RestaurantController;
import com.example.utils.consoleUtils.ConsoleUtils;

public class Menu {
    private final RestaurantController restaurantController;
    private final ConsoleUtils console;

    public Menu(RestaurantController restaurantController, ConsoleUtils console) {
        this.restaurantController = restaurantController;
        this.console = console;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Agregar Restaurante");
            System.out.println("0. Salir");
            int choice = console.getInteger("Elige una opción: ");

            switch (choice) {
                case 1 -> restaurantController.addRestaurant();
                case 0 -> exit = true;
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}