package com.example.services.restaurant;

import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RemoveRestaurantServiceTest {
    private RemoveRestaurantService service;
    private RestaurantRepository repository;
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        repository = mock(RestaurantRepository.class);
        service = new RemoveRestaurantService(repository);
        restaurant = new Restaurant("Restaurante de Prueba", "123456", "Dirección de Prueba", 1, null, null, 0.0);
    }

    @Test
    void shouldRemoveRestaurantWhenRestaurantExists() {
        when(repository.findByName("Restaurante de Prueba")).thenReturn(restaurant);
        service.setRestaurant(restaurant);
        service.execute();
        verify(repository).removeRestaurant(restaurant);
    }

    @Test
    void shouldReturnNullWhenRestaurantDoesNotExist() {
        when(repository.findByName("Restaurante Inexistente")).thenReturn(null);
        service.setRestaurant(new Restaurant("Restaurante Inexistente", "654321", "Otra Dirección", 0, null, null, 0.0));
        Restaurant result = service.execute();
        assertNull(result, "El restaurante debería ser nulo cuando no se encuentra en el repositorio.");
        verify(repository, times(0)).removeRestaurant(any(Restaurant.class));
    }

    @Test
    void shouldFindRestaurantByName() {
        when(repository.findByName("Restaurante de Prueba")).thenReturn(restaurant);
        Restaurant result = service.findByName("Restaurante de Prueba");
        assertNotNull(result, "El restaurante no debería ser nulo.");
        assertEquals("Restaurante de Prueba", result.getName(), "El nombre del restaurante debería ser 'Restaurante de Prueba'");
    }
}