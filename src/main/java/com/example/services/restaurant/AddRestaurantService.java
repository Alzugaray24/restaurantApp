// src/main/java/com/example/services/restaurant/AddRestaurantService.java
package com.example.services.restaurant;

import com.example.dtos.RestaurantDTO;
import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

public class AddRestaurantService implements ICommand<Restaurant> {

    private final RestaurantRepository repository;
    private RestaurantDTO restaurantDTO;

    public AddRestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public void setRestaurantDTO(RestaurantDTO restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }

    @Override
    public Restaurant execute() {
        if (restaurantDTO == null) {
            throw new IllegalStateException("Los datos del restaurante no pueden ser nulos");
        }
        Restaurant restaurant = new Restaurant(
                restaurantDTO.getName(),
                restaurantDTO.getPhone(),
                restaurantDTO.getAddress(),
                restaurantDTO.getAvailable(),
                null,
                null,
                0.0
        );
        repository.addRestaurant(restaurant);
        return restaurant;
    }
}