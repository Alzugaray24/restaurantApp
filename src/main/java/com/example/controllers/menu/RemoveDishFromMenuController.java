package com.example.controllers.menu;

import com.example.models.Dish;
import com.example.models.Restaurant;
import com.example.services.menu.RemoveDishFromMenuService;
import com.example.utils.consoleUtils.ConsoleUtils;
import com.example.repositories.RestaurantRepository;

public class RemoveDishFromMenuController {
    private final RemoveDishFromMenuService removeDishFromMenuService;
    private final ConsoleUtils console;
    private final RestaurantRepository restaurantRepository;

    public RemoveDishFromMenuController(RemoveDishFromMenuService removeDishFromMenuService, ConsoleUtils console, RestaurantRepository restaurantRepository) {
        this.removeDishFromMenuService = removeDishFromMenuService;
        this.console = console;
        this.restaurantRepository = restaurantRepository;
    }

    public void removeDishFromMenu() {
        try {
            String restaurantName = console.getString("Ingrese el nombre del restaurante: ");
            Restaurant restaurant = restaurantRepository.findByName(restaurantName);
            if (restaurant == null) {
                System.out.println("Restaurante no encontrado");
                return;
            }

            String dishName = console.getString("Ingrese el nombre del plato a eliminar: ");
            Dish dish = restaurant.getMenu().getDishes().stream()
                    .filter(d -> d.getName().equals(dishName))
                    .findFirst()
                    .orElse(null);

            if (dish == null) {
                System.out.println("Plato no encontrado en el menú");
                return;
            }

            removeDishFromMenuService.setRestaurant(restaurant);
            removeDishFromMenuService.setDish(dish);
            removeDishFromMenuService.execute();
            System.out.println("Plato eliminado del menú");
        } catch (Exception e) {
            System.out.println("Error al eliminar el plato del menú: " + e.getMessage());
        }
    }
}