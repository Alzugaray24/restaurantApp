package com.example.services.restaurant;

import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

public class AddRestaurantService implements ICommand<Restaurant> {

    private final RestaurantRepository repository;
    private Restaurant restaurant;

    public AddRestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public Restaurant execute() {
        if (restaurant == null) {
            throw new IllegalStateException("Restaurant data cannot be null");
        }
        repository.addRestaurant(restaurant);
        return restaurant;
    }
}