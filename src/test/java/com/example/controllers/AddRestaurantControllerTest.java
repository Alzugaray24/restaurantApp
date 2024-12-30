package com.example.controllers;

import com.example.controllers.restaurant.AddRestaurantController;
import com.example.models.Restaurant;
import com.example.services.restaurant.AddRestaurantService;
import com.example.utils.consoleUtils.ConsoleUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class AddRestaurantControllerTest {
    private AddRestaurantController controller;
    private AddRestaurantService service;
    private ConsoleUtils console;

    @BeforeEach
    void setUp() {
        service = mock(AddRestaurantService.class);
        console = mock(ConsoleUtils.class);
        controller = new AddRestaurantController(service, console);
    }

    @Test
    void shouldAddRestaurantWhenInputIsValid() {
        when(console.getString("Entra el nombre del restaurante: ")).thenReturn("Restaurante de Prueba");
        when(console.getString("Entra el teléfono del restaurante: ")).thenReturn("123456");
        when(console.getString("Entra la dirección del restaurante: ")).thenReturn("Dirección de Prueba");
        when(console.getInteger("Entra la disponibilidad del restaurante: ")).thenReturn(1);

        controller.addRestaurant();

        verify(service).setRestaurant(Mockito.any(Restaurant.class));
        verify(service).execute();
    }

    @Test
    void shouldHandleExceptionWhenServiceFails() {
        when(console.getString("Entra el nombre del restaurante: ")).thenReturn("Restaurante de Prueba");
        when(console.getString("Entra el teléfono del restaurante: ")).thenReturn("123456");
        when(console.getString("Entra la dirección del restaurante: ")).thenReturn("Dirección de Prueba");
        when(console.getInteger("Entra la disponibilidad del restaurante: ")).thenReturn(1);

        doThrow(new RuntimeException("Error del Servicio")).when(service).execute();

        controller.addRestaurant();
    }
}