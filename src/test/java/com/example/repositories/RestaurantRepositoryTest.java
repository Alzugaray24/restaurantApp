package com.example.repositories;

import com.example.models.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryTest {
    private RestaurantRepository repository;

    @BeforeEach
    void setUp() {
        repository = RestaurantRepository.getInstance();
        repository.getRestaurants().clear();
    }

    @Test
    void shouldAddRestaurant() {
        Restaurant restaurant = new Restaurant("Restaurante de Prueba", "123456", "Dirección de Prueba", 1, null, null, 0.0);
        repository.addRestaurant(restaurant);

        assertEquals(1, repository.getRestaurants().size(), "El número de restaurantes debería ser 1");
        assertEquals("Restaurante de Prueba", repository.getRestaurants().get(0).getName(), "El nombre del restaurante debería ser 'Restaurante de Prueba'");
    }

    @Test
    void shouldRemoveRestaurant() {
        Restaurant restaurant = new Restaurant("Restaurante de Prueba", "123456", "Dirección de Prueba", 1, null, null, 0.0);
        repository.addRestaurant(restaurant);
        repository.removeRestaurant(restaurant);

        assertTrue(repository.getRestaurants().isEmpty(), "La lista de restaurantes debería estar vacía");
    }

    @Test
    void shouldUpdateRestaurant() {
        Restaurant restaurant = new Restaurant("Restaurante de Prueba", "123456", "Dirección de Prueba", 1, null, null, 0.0);
        repository.addRestaurant(restaurant);

        Restaurant updatedRestaurant = new Restaurant("Restaurante de Prueba", "654321", "Dirección Actualizada", 0, null, null, 5.0);
        repository.updateRestaurant(updatedRestaurant);

        Restaurant result = repository.findByName("Restaurante de Prueba");
        assertNotNull(result, "El restaurante no debería ser nulo");
        assertEquals("654321", result.getPhone(), "El teléfono del restaurante debería ser '654321'");
        assertEquals("Dirección Actualizada", result.getAddress(), "La dirección del restaurante debería ser 'Dirección Actualizada'");
    }

    @Test
    void shouldFindByName() {
        Restaurant restaurant = new Restaurant("Restaurante de Prueba", "123456", "Dirección de Prueba", 1, null, null, 0.0);
        repository.addRestaurant(restaurant);

        Restaurant result = repository.findByName("Restaurante de Prueba");

        assertNotNull(result, "El restaurante no debería ser nulo");
        assertEquals("Dirección de Prueba", result.getAddress(), "La dirección del restaurante debería ser 'Dirección de Prueba'");
    }
}