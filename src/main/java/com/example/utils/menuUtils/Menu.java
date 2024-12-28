package com.example.utils.menuUtils;

import com.example.controllers.menu.AddDishToMenuController;
import com.example.controllers.menu.RemoveDishFromMenuController;
import com.example.controllers.menu.UpdateDishFromMenuController;
import com.example.controllers.restaurant.AddRestaurantController;
import com.example.controllers.restaurant.RemoveRestaurantController;
import com.example.controllers.restaurant.ShowRestaurantsController;
import com.example.controllers.restaurant.UpdateRestaurantController;
import com.example.utils.consoleUtils.ConsoleUtils;

public class Menu {
    private final AddRestaurantController addRestaurantController;
    private final RemoveRestaurantController removeRestaurantController;
    private final ShowRestaurantsController showRestaurantsController;
    private final UpdateRestaurantController updateRestaurantController;
    private final AddDishToMenuController addDishToMenuController;
    private final RemoveDishFromMenuController removeDishFromMenuController;
    private final UpdateDishFromMenuController updateDishFromMenuController;
    private final ConsoleUtils console;

    public Menu(AddRestaurantController addRestaurantController, RemoveRestaurantController removeRestaurantController, ShowRestaurantsController showRestaurantsController, UpdateRestaurantController updateRestaurantController, AddDishToMenuController addDishToMenuController, RemoveDishFromMenuController removeDishFromMenuController, UpdateDishFromMenuController updateDishFromMenuController, ConsoleUtils console) {
        this.addRestaurantController = addRestaurantController;
        this.removeRestaurantController = removeRestaurantController;
        this.showRestaurantsController = showRestaurantsController;
        this.updateRestaurantController = updateRestaurantController;
        this.addDishToMenuController = addDishToMenuController;
        this.removeDishFromMenuController = removeDishFromMenuController;
        this.updateDishFromMenuController = updateDishFromMenuController;
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
            System.out.println("0. Salir");
            int choice = console.getInteger("Elige una opción: ");

            switch (choice) {
                case 1 -> addRestaurantController.addRestaurant();
                case 2 -> removeRestaurantController.removeRestaurant();
                case 3 -> showRestaurantsController.showRestaurants();
                case 4 -> updateRestaurantController.updateRestaurant();
                case 5 -> manageMenu();
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
}