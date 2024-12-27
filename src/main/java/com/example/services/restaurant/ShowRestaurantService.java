package com.example.services.restaurant;

import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

import java.util.List;

public class ShowRestaurantService implements ICommand<List<Restaurant>> {

    private final RestaurantRepository repository;

    public ShowRestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Restaurant> execute() {
        return repository.getRestaurants();
    }
}