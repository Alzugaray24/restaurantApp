package com.example.controllers.restaurant;

import com.example.models.Restaurant;
import com.example.services.restaurant.UpdateRestaurantService;
import com.example.utils.consoleUtils.ConsoleUtils;

public class UpdateRestaurantController {
    private final UpdateRestaurantService updateRestaurantService;
    private final ConsoleUtils console;

    public UpdateRestaurantController(UpdateRestaurantService updateRestaurantService, ConsoleUtils console) {
        this.updateRestaurantService = updateRestaurantService;
        this.console = console;
    }

    public void updateRestaurant() {
        try {
            if (updateRestaurantService.getRepository().getRestaurants().isEmpty()) {
                System.out.println("No hay restaurantes disponibles para actualizar.");
                return;
            }

            String name = console.getString("Ingrese el nombre del restaurante a actualizar: ");
            Restaurant restaurant = updateRestaurantService.findByName(name);
            if (restaurant == null) {
                System.out.println("Restaurante no encontrado.");
                return;
            }

            String phone = console.getString("Ingrese el nuevo teléfono: ");
            String address = console.getString("Ingrese la nueva dirección: ");
            Integer available = console.getInteger("Ingrese la nueva disponibilidad: ");

            restaurant.setPhone(phone);
            restaurant.setAddress(address);
            restaurant.setAvailable(available);

            updateRestaurantService.setRestaurant(restaurant);
            updateRestaurantService.execute();

            System.out.println("Restaurante actualizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el restaurante: " + e.getMessage());
        }
    }
}