package com.example.services.menu;

import com.example.models.Dish;
import com.example.models.Menu;
import com.example.models.Restaurant;
import com.example.repositories.MenuRepository;
import com.example.services.interfaces.ICommand;

public class AddDishToMenuService implements ICommand<Menu> {

    private final MenuRepository repository;
    private Restaurant restaurant;
    private Dish dish;

    public AddDishToMenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public Menu execute() {
        if (restaurant == null || dish == null) {
            throw new IllegalStateException("El restaurante y el plato no pueden ser nulos");
        }
        repository.addDishToMenu(restaurant, dish);
        return repository.getMenuByRestaurant(restaurant);
    }
}