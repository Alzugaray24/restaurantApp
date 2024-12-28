package com.example.services.restaurant;

import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

public class RemoveRestaurantService implements ICommand<Restaurant> {

    private final RestaurantRepository repository;
    private Restaurant restaurant;

    public RemoveRestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }



    @Override
    public Restaurant execute() {
        Restaurant restaurant = repository.findByName(this.restaurant.getName());
        if (restaurant != null) {
            repository.removeRestaurant(restaurant);
        }
        return restaurant;
    }

    public Restaurant findByName(String name) {
        return repository.findByName(name);
    }
}