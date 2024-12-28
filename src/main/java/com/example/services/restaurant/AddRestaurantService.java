package com.example.services.restaurant;

import com.example.dtos.RestaurantDTO;
import com.example.models.Menu;
import com.example.models.Restaurant;
import com.example.models.Review;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalStateException("Restaurant data cannot be null");
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