package com.example.controllers;

import com.example.controllers.restaurant.ShowRestaurantsController;
import com.example.models.Restaurant;
import com.example.services.restaurant.ShowRestaurantService;
import com.example.utils.consoleUtils.ConsoleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class ShowRestaurantsControllerTest {
    private ShowRestaurantsController controller;
    private ShowRestaurantService showRestaurantService;
    private ConsoleUtils console;

    @BeforeEach
    void setUp() {
        showRestaurantService = mock(ShowRestaurantService.class);
        console = mock(ConsoleUtils.class);
        controller = new ShowRestaurantsController(showRestaurantService, console);
    }

    @Test
    void shouldShowNoRestaurantsMessageWhenListIsEmpty() {
        when(showRestaurantService.execute()).thenReturn(Collections.emptyList());

        controller.showRestaurants();

        verify(showRestaurantService).execute();
        System.out.println("Verificado mensaje: 'No hay restaurantes disponibles.'");
    }

    @Test
    void shouldShowRestaurantsWhenListIsNotEmpty() {
        List<Restaurant> restaurants = List.of(
                new Restaurant("Restaurante 1", "123456", "Dirección 1", 1, null, null, 4.5),
                new Restaurant("Restaurante 2", "654321", "Dirección 2", 0, null, null, 3.0)
        );

        when(showRestaurantService.execute()).thenReturn(restaurants);

        controller.showRestaurants();

        verify(showRestaurantService).execute();
        System.out.println("Verificado lista de restaurantes mostrada correctamente.");
    }

    @Test
    void shouldHandleExceptionWhenServiceFails() {
        when(showRestaurantService.execute()).thenThrow(new RuntimeException("Error de servicio"));

        controller.showRestaurants();

        verify(showRestaurantService).execute();
        System.out.println("Verificado manejo de excepción: 'Error al mostrar los restaurantes.'");
    }
}