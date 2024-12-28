// src/main/java/com/example/repositories/DishRepository.java
package com.example.repositories;

import com.example.models.Dish;

import java.util.ArrayList;
import java.util.List;

public class DishRepository {
    private static DishRepository instance;
    private final List<Dish> dishes = new ArrayList<>();

    private DishRepository() {

    }

    public static DishRepository getInstance() {
        if (instance == null) {
            instance = new DishRepository();
        }
        return instance;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    public Dish findByName(String name) {
        return dishes.stream()
                .filter(dish -> dish.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes);
    }
}