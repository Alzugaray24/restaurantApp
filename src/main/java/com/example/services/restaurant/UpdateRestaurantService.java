package com.example.services.restaurant;

import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

public class UpdateRestaurantService implements ICommand<Restaurant> {

    private final RestaurantRepository repository;
    private Restaurant restaurant;

    public UpdateRestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant findByName(String name) {
        return repository.findByName(name);
    }

    public RestaurantRepository getRepository() {
        return repository;
    }

    @Override
    public Restaurant execute() {
        if (restaurant == null) {
            throw new IllegalStateException("Restaurant data cannot be null");
        }
        repository.updateRestaurant(restaurant);
        return restaurant;
    }
}