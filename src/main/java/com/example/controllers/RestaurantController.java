package com.example.controllers;

import com.example.dtos.RestaurantDTO;
import com.example.models.Restaurant;
import com.example.services.restaurant.AddRestaurant;
import com.example.utils.consoleUtils.ConsoleUtils;

public class RestaurantController {
    private final AddRestaurant addRestaurantService;
    private final ConsoleUtils console;

    public RestaurantController(AddRestaurant addRestaurantService, ConsoleUtils console) {
        this.addRestaurantService = addRestaurantService;
        this.console = console;
    }

    public void addRestaurant() {
        try {
            String name = console.getString("Entra el nombre del restaurante: ");
            String phone = console.getString("Entra el teléfono del restaurante: ");
            String address = console.getString("Entra la dirección del restaurante: ");
            Integer available = console.getInteger("Entra la disponibilidad del restaurante: ");

            RestaurantDTO restaurantDTO = new RestaurantDTO(name, phone, address, available);
            Restaurant restaurant = addRestaurantService.execute(restaurantDTO);
            System.out.println("Restaurante agregado: " + restaurant.getName());
        } catch (Exception e) {
            System.out.println("Error al agregar el restaurante: " + e.getMessage());
        }
    }
}