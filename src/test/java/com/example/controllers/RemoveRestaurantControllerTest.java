package com.example.controllers;

import com.example.controllers.restaurant.RemoveRestaurantController;
import com.example.models.Restaurant;
import com.example.services.restaurant.RemoveRestaurantService;
import com.example.utils.consoleUtils.ConsoleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class RemoveRestaurantControllerTest {
    private RemoveRestaurantController controller;
    private RemoveRestaurantService service;
    private ConsoleUtils console;

    @BeforeEach
    void setUp() {
        service = mock(RemoveRestaurantService.class);
        console = mock(ConsoleUtils.class);
        controller = new RemoveRestaurantController(service, console);
    }

    @Test
    void shouldRemoveRestaurantWhenNameIsValid() {
        String restaurantName = "Restaurante de Prueba";
        Restaurant restaurant = new Restaurant(restaurantName, "123456", "Dirección de Prueba", 1, null, null, 0.0);

        when(console.getString("Entra el nombre del restaurante que deseas eliminar: ")).thenReturn(restaurantName);
        when(service.findByName(restaurantName)).thenReturn(restaurant);

        controller.removeRestaurant();

        verify(service).findByName(restaurantName);
        verify(service).setRestaurant(restaurant);
        verify(service).execute();
    }

    @Test
    void shouldHandleRestaurantNotFound() {
        String restaurantName = "Restaurante Inexistente";

        when(console.getString("Entra el nombre del restaurante que deseas eliminar: ")).thenReturn(restaurantName);
        when(service.findByName(restaurantName)).thenReturn(null);

        controller.removeRestaurant();

        verify(service).findByName(restaurantName);
    }

    @Test
    void shouldHandleExceptionWhenServiceFails() {
        String restaurantName = "Restaurante de Prueba";

        when(console.getString("Entra el nombre del restaurante que deseas eliminar: ")).thenReturn(restaurantName);
        when(service.findByName(restaurantName)).thenReturn(new Restaurant(restaurantName, "123456", "Dirección de Prueba", 1, null, null, 0.0));

        doThrow(new RuntimeException("Error al eliminar el restaurante")).when(service).execute();

        controller.removeRestaurant();
    }
}