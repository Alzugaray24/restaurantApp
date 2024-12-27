package com.example.services.restaurant;

import com.example.dtos.RestaurantDTO;
import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

public class RemoveRestaurantService implements ICommand<Restaurant> {

    private final RestaurantRepository repository;
    private RestaurantDTO restaurantDTO;

    public RemoveRestaurantService(RestaurantRepository repository) {
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
        Restaurant restaurant = repository.findByName(restaurantDTO.getName());
        if (restaurant != null) {
            repository.removeRestaurant(restaurant);
        }
        return restaurant;
    }
}