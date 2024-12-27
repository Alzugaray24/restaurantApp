package com.example.services.restaurant;

import com.example.dtos.RestaurantDTO;
import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import com.example.services.interfaces.ICommand;

public class UpdateRestaurantService implements ICommand<Restaurant> {

    private final RestaurantRepository repository;
    private RestaurantDTO restaurantDTO;

    public UpdateRestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public void setRestaurantDTO(RestaurantDTO restaurantDTO) {
        this.restaurantDTO = restaurantDTO;
    }

    public RestaurantRepository getRepository() {
        return repository;
    }

    @Override
    public Restaurant execute() {
        validateRestaurantDTO();
        validateRestaurantsAvailability();

        Restaurant restaurant = findRestaurantByName(restaurantDTO.getName());
        updateRestaurantDetails(restaurant);

        return restaurant;
    }

    private void validateRestaurantDTO() {
        if (restaurantDTO == null) {
            throw new IllegalStateException("Los datos del restaurante no pueden ser nulos");
        }
    }

    private void validateRestaurantsAvailability() {
        if (repository.getRestaurants().isEmpty()) {
            throw new IllegalStateException("No hay restaurantes disponibles para actualizar");
        }
    }

    private Restaurant findRestaurantByName(String name) {
        Restaurant restaurant = repository.findByName(name);
        if (restaurant == null) {
            throw new IllegalStateException("No se encontró un restaurante con el nombre proporcionado");
        }
        return restaurant;
    }

    private void updateRestaurantDetails(Restaurant restaurant) {
        restaurant.setPhone(restaurantDTO.getPhone());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setAvailable(restaurantDTO.getAvailable());
        repository.updateRestaurant(restaurant);
    }
}