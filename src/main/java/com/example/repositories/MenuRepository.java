package com.example.repositories;

import com.example.models.Dish;
import com.example.models.Menu;
import com.example.models.Restaurant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MenuRepository {
    private static MenuRepository instance;
    private final Map<Restaurant, Menu> menus;

    private MenuRepository() {
        menus = new HashMap<>();
    }

    public static MenuRepository getInstance() {
        if (instance == null) {
            instance = new MenuRepository();
        }
        return instance;
    }

    public Menu getMenuByRestaurant(Restaurant restaurant) {
        return menus.get(restaurant);
    }

    public void addDishToMenu(Restaurant restaurant, Dish dish) {
        Menu menu = menus.computeIfAbsent(restaurant, r -> new Menu(r, new LinkedList<>()));
        menu.getDishes().add(dish);
        restaurant.setMenu(menu);
    }

    public void removeDishFromMenu(Restaurant restaurant, Dish dish) {
        Menu menu = menus.get(restaurant);
        if (menu != null) {
            menu.getDishes().remove(dish);
        }
    }

    public void clearMenu(Restaurant restaurant) {
        Menu menu = menus.get(restaurant);
        if (menu != null) {
            menu.getDishes().clear();
        }
    }
}