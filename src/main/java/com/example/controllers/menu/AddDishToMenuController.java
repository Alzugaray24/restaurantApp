package com.example.controllers.menu;

import com.example.models.Dish;
import com.example.models.Restaurant;
import com.example.observer.ConsoleNotifier;
import com.example.repositories.MenuRepository;
import com.example.repositories.RestaurantRepository;
import com.example.services.menu.AddDishToMenuService;
import com.example.utils.consoleUtils.ConsoleUtils;

import java.util.ArrayList;

public class AddDishToMenuController {
    private final AddDishToMenuService addDishToMenuService;
    private final ConsoleUtils console;
    private final RestaurantRepository restaurantRepository;

    public AddDishToMenuController(AddDishToMenuService addDishToMenuService, ConsoleUtils console, RestaurantRepository restaurantRepository) {
        this.addDishToMenuService = addDishToMenuService;
        this.console = console;
        this.restaurantRepository = restaurantRepository;

        MenuRepository menuRepository = MenuRepository.getInstance();
        menuRepository.addObserver(new ConsoleNotifier());
    }

    public void addDishToMenu() {
        try {
            String restaurantName = console.getString("Ingrese el nombre del restaurante: ");
            Restaurant restaurant = restaurantRepository.findByName(restaurantName);
            if (restaurant == null) {
                System.out.println("Restaurante no encontrado.");
                return;
            }

            String dishName = console.getString("Ingrese el nombre del plato: ");
            String dishDescription = console.getString("Ingrese la descripción del plato: ");
            double dishPrice = console.getDouble("Ingrese el precio del plato: ");
            Dish dish = new Dish(dishName, dishDescription, dishPrice, new ArrayList<>());

            addDishToMenuService.setRestaurant(restaurant);
            addDishToMenuService.setDish(dish);
            addDishToMenuService.execute();

            System.out.println("Plato agregado al menú.");
        } catch (Exception e) {
            System.out.println("Error al agregar el plato al menú: " + e.getMessage());
        }
    }
}