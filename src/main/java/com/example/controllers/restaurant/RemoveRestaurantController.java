package com.example.controllers.restaurant;

import com.example.models.Restaurant;
import com.example.services.restaurant.RemoveRestaurantService;
import com.example.utils.consoleUtils.ConsoleUtils;

public class RemoveRestaurantController {
    private final RemoveRestaurantService removeRestaurantService;
    private final ConsoleUtils console;

    public RemoveRestaurantController(RemoveRestaurantService removeRestaurantService, ConsoleUtils console) {
        this.removeRestaurantService = removeRestaurantService;
        this.console = console;
    }

    public void removeRestaurant() {
        try {
            String name = console.getString("Entra el nombre del restaurante que deseas eliminar: ");
            Restaurant restaurant = removeRestaurantService.findByName(name);
            if (restaurant != null) {
                removeRestaurantService.setRestaurant(restaurant);
                removeRestaurantService.execute();
                System.out.println("Restaurante eliminado: " + restaurant.getName());
            } else {
                System.out.println("Restaurante no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el restaurante: " + e.getMessage());
        }
    }
}