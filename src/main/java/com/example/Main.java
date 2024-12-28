package com.example;

import com.example.config.initializers.ServiceInitializer;
import com.example.config.initializers.ControllerInitializer;
import com.example.utils.consoleUtils.ConsoleUtils;
import com.example.utils.menuUtils.Menu;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils console = new ConsoleUtils();
        ServiceInitializer serviceInitializer = new ServiceInitializer();
        ControllerInitializer controllerInitializer = new ControllerInitializer(serviceInitializer, console);

        Menu menu = new Menu(
                // Controlador Restaurante
                controllerInitializer.addRestaurantController,
                controllerInitializer.removeRestaurantController,
                controllerInitializer.showRestaurantsController,
                controllerInitializer.updateRestaurantController,

                // Controlador Menú
                controllerInitializer.addDishToMenuController,
                controllerInitializer.removeDishFromMenuController,
                controllerInitializer.updateDishFromMenuController,

                // Controlador Reseñas
                controllerInitializer.addReviewController,
                controllerInitializer.listReviewController,
                controllerInitializer.calculateAverageRatingController,

                // Consola
                console
        );

        menu.showMenu();
    }
}