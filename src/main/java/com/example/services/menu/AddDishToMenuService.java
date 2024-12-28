package com.example.services.menu;

import com.example.models.Dish;
import com.example.models.Menu;
import com.example.models.Restaurant;
import com.example.repositories.MenuRepository;
import com.example.services.interfaces.ICommand;

import java.util.LinkedList;

public class AddDishToMenuService implements ICommand<Void> {
    private final MenuRepository menuRepository;
    private Restaurant restaurant;
    private Dish dish;

    public AddDishToMenuService(MenuRepository menuRepository) {
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
        validateInputs();
        Menu menu = getOrCreateMenu();
        addDishToMenu(menu);
        return null;
    }

    private void validateInputs() {
        if (restaurant == null || dish == null) {
            throw new IllegalStateException("El restaurante y el plato no pueden ser nulos");
        }
    }

    private Menu getOrCreateMenu() {
        Menu menu = menuRepository.getMenuByRestaurant(restaurant);
        if (menu == null) {
            menu = new Menu(restaurant, new LinkedList<>());
            restaurant.setMenu(menu);
        }
        return menu;
    }

    private void addDishToMenu(Menu menu) {
        menuRepository.addDishToMenu(restaurant, dish);
    }
}