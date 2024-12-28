package com.example.config.initializers;

import com.example.controllers.menu.AddDishToMenuController;
import com.example.controllers.restaurant.AddRestaurantController;
import com.example.controllers.restaurant.RemoveRestaurantController;
import com.example.controllers.restaurant.ShowRestaurantsController;
import com.example.controllers.restaurant.UpdateRestaurantController;
import com.example.utils.consoleUtils.ConsoleUtils;

public class ControllerInitializer {
    public final AddRestaurantController addRestaurantController;
    public final RemoveRestaurantController removeRestaurantController;
    public final ShowRestaurantsController showRestaurantsController;
    public final UpdateRestaurantController updateRestaurantController;
    public final AddDishToMenuController addDishToMenuController;

    public ControllerInitializer(ServiceInitializer serviceInitializer, ConsoleUtils console) {
        this.addRestaurantController = new AddRestaurantController(serviceInitializer.addRestaurantService, console);
        this.removeRestaurantController = new RemoveRestaurantController(serviceInitializer.removeRestaurantService, console);
        this.showRestaurantsController = new ShowRestaurantsController(serviceInitializer.showRestaurantService, console);
        this.updateRestaurantController = new UpdateRestaurantController(serviceInitializer.updateRestaurantService, console);
        this.addDishToMenuController = new AddDishToMenuController(serviceInitializer.addDishToMenuService, console, serviceInitializer.getRestaurantRepository());
    }
}