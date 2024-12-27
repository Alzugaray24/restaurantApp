package com.example;

import com.example.controllers.RestaurantController;
import com.example.repositories.RestaurantRepository;
import com.example.services.restaurant.AddRestaurant;
import com.example.utils.consoleUtils.ConsoleUtils;
import com.example.utils.menuUtils.Menu;

public class Main {
    public static void main(String[] args) {
        RestaurantRepository repository = RestaurantRepository.getInstance();
        AddRestaurant addRestaurantService = new AddRestaurant(repository);
        ConsoleUtils console = new ConsoleUtils();
        RestaurantController restaurantController = new RestaurantController(addRestaurantService, console);
        Menu menu = new Menu(restaurantController, console);

        menu.showMenu();
    }
}