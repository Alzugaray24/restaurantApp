package com.example.services.restaurant;

import com.example.dtos.RestaurantDTO;
import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

public class AddRestaurant implements ICommand<RestaurantDTO, Restaurant> {

    private final RestaurantRepository repository;

    public AddRestaurant(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant execute(RestaurantDTO restaurantDTO) {
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