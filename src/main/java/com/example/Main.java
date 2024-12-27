// src/main/java/com/example/Main.javaa
package com.example;

import com.example.controllers.restaurant.AddRestaurantController;
import com.example.controllers.restaurant.RemoveRestaurantController;
import com.example.controllers.restaurant.ShowRestaurantsController;
import com.example.controllers.restaurant.UpdateRestaurantController;
import com.example.repositories.RestaurantRepository;
import com.example.services.restaurant.AddRestaurantService;
import com.example.services.restaurant.RemoveRestaurantService;
import com.example.services.restaurant.ShowRestaurantService;
import com.example.services.restaurant.UpdateRestaurantService;
import com.example.utils.consoleUtils.ConsoleUtils;
import com.example.utils.menuUtils.Menu;

public class Main {
    public static void main(String[] args) {
        RestaurantRepository repository = RestaurantRepository.getInstance();
        AddRestaurantService addRestaurantService = new AddRestaurantService(repository);
        RemoveRestaurantService removeRestaurantService = new RemoveRestaurantService(repository);
        ShowRestaurantService showRestaurantService = new ShowRestaurantService(repository);
        UpdateRestaurantService updateRestaurantService = new UpdateRestaurantService(repository);
        ConsoleUtils console = new ConsoleUtils();
        AddRestaurantController addRestaurantController = new AddRestaurantController(addRestaurantService, console);
        RemoveRestaurantController removeRestaurantController = new RemoveRestaurantController(removeRestaurantService, console);
        ShowRestaurantsController showRestaurantsController = new ShowRestaurantsController(showRestaurantService, console);
        UpdateRestaurantController updateRestaurantController = new UpdateRestaurantController(updateRestaurantService, console);

        Menu menu = new Menu(addRestaurantController, removeRestaurantController, showRestaurantsController, updateRestaurantController, console);

        menu.showMenu();
    }
}