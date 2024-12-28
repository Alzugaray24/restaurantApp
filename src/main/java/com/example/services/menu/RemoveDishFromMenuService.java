package com.example.services.menu;

import com.example.models.Dish;
import com.example.models.Restaurant;
import com.example.repositories.MenuRepository;
import com.example.services.interfaces.ICommand;

public class RemoveDishFromMenuService implements ICommand<Void> {
    private final MenuRepository menuRepository;
    private Restaurant restaurant;
    private Dish dish;

    public RemoveDishFromMenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public Void execute() {
        if (restaurant == null || dish == null) {
            throw new IllegalStateException("El restaurante y el plato no pueden ser nulos");
        }
        menuRepository.removeDishFromMenu(restaurant, dish);
        return null;
    }
}