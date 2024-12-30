package com.example.services.restaurant;

import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddRestaurantServiceTest {
    private AddRestaurantService service;
    private RestaurantRepository repository;

    @BeforeEach
    void setUp() {
        repository = RestaurantRepository.getInstance();
        repository.getRestaurants().clear();
        service = new AddRestaurantService(repository);
    }

    @Test
    void shouldAddRestaurantSuccessfully() {
        Restaurant restaurant = new Restaurant("Service Test", "987654", "Service Address", 1, null, null, 0.0);
        service.setRestaurant(restaurant);

        Restaurant result = service.execute();

        assertEquals(1, repository.getRestaurants().size(), "El número de restaurantes debería ser 1");
        assertEquals("Service Test", result.getName(), "El nombre del restaurante debería ser 'Service Test'");
    }

    @Test
    void shouldThrowExceptionWhenRestaurantIsNull() {
        Exception exception = assertThrows(IllegalStateException.class, service::execute);
        assertEquals("Restaurant data cannot be null", exception.getMessage(), "El mensaje de la excepción debería ser 'Restaurant data cannot be null'");
    }
}