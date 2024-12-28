package com.example;

import com.example.config.initializers.ServiceInitializer;
import com.example.config.initializers.ControllerInitializer;
import com.example.utils.consoleUtils.ConsoleUtils;
import com.example.utils.menuUtils.MainMenuUtils;
import com.example.utils.menuUtils.RestaurantMenuUtils;
import com.example.utils.menuUtils.ManageMenuUtils;
import com.example.utils.menuUtils.ManageReviewsUtils;

public class Main {
    public static void main(String[] args) {
        ConsoleUtils console = new ConsoleUtils();
        ServiceInitializer serviceInitializer = new ServiceInitializer();
        ControllerInitializer controllerInitializer = new ControllerInitializer(serviceInitializer, console);

        RestaurantMenuUtils restaurantMenuUtils = new RestaurantMenuUtils(
                controllerInitializer.addRestaurantController,
                controllerInitializer.removeRestaurantController,
                controllerInitializer.showRestaurantsController,
                controllerInitializer.updateRestaurantController,
                console
        );

        ManageMenuUtils manageMenuUtils = new ManageMenuUtils(
                controllerInitializer.addDishToMenuController,
                controllerInitializer.removeDishFromMenuController,
                controllerInitializer.updateDishFromMenuController,
                console
        );

        ManageReviewsUtils manageReviewsUtils = new ManageReviewsUtils(
                controllerInitializer.addReviewController,
                controllerInitializer.listReviewController,
                controllerInitializer.calculateAverageRatingController,
                console
        );

        MainMenuUtils mainMenuUtils = new MainMenuUtils(
                restaurantMenuUtils,
                manageMenuUtils,
                manageReviewsUtils,
                console
        );

        mainMenuUtils.showMenu();
    }
}