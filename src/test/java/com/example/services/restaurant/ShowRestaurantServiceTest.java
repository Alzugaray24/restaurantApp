package com.example.services.restaurant;

import com.example.models.Restaurant;
import com.example.repositories.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShowRestaurantServiceTest {

    private ShowRestaurantService service;
    private RestaurantRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(RestaurantRepository.class);
        service = new ShowRestaurantService(repository);
    }

    @Test
    void shouldReturnEmptyListWhenNoRestaurantsAreAvailable() {
        when(repository.getRestaurants()).thenReturn(Collections.emptyList());

        List<Restaurant> restaurants = service.execute();

        assertTrue(restaurants.isEmpty(), "La lista de restaurantes debería estar vacía");
        verify(repository).getRestaurants();
    }

    @Test
    void shouldReturnListOfRestaurantsWhenRestaurantsAreAvailable() {
        List<Restaurant> mockRestaurants = List.of(
                new Restaurant("Restaurante 1", "123456", "Dirección 1", 1, null, null, 4.5),
                new Restaurant("Restaurante 2", "654321", "Dirección 2", 0, null, null, 3.0)
        );

        when(repository.getRestaurants()).thenReturn(mockRestaurants);

        List<Restaurant> restaurants = service.execute();

        assertEquals(2, restaurants.size(), "La lista de restaurantes debería contener 2 elementos");
        assertEquals("Restaurante 1", restaurants.get(0).getName(), "El primer restaurante debería ser 'Restaurante 1'");
        assertEquals("Restaurante 2", restaurants.get(1).getName(), "El segundo restaurante debería ser 'Restaurante 2'");
        verify(repository).getRestaurants();
    }

    @Test
    void shouldHandleRepositoryException() {
        when(repository.getRestaurants()).thenThrow(new RuntimeException("Error en el repositorio"));

        RuntimeException exception = assertThrows(RuntimeException.class, service::execute);

        assertEquals("Error en el repositorio", exception.getMessage(), "El mensaje de la excepción debería coincidir");
        verify(repository).getRestaurants();
    }
}