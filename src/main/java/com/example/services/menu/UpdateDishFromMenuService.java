package com.example.services.menu;

import com.example.models.Dish;
import com.example.models.Menu;
import com.example.models.Restaurant;
import com.example.repositories.MenuRepository;
import com.example.services.interfaces.ICommand;

public class UpdateDishFromMenuService implements ICommand<Void> {
    private final MenuRepository menuRepository;
    private Restaurant restaurant;
    private Dish updatedDish;

    public UpdateDishFromMenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setUpdatedDish(Dish updatedDish) {
        this.updatedDish = updatedDish;
    }

    @Override
    public Void execute() {
        if (restaurant == null || updatedDish == null) {
            throw new IllegalStateException("El restaurante y el plato no pueden ser nulos");
        }

        Menu menu = menuRepository.getMenuByRestaurant(restaurant);
        if (menu != null) {
            for (Dish dish : menu.getDishes()) {
                if (dish.getName().equals(updatedDish.getName())) {
                    dish.setDescription(updatedDish.getDescription());
                    dish.setPrice(updatedDish.getPrice());
                    dish.setReviews(updatedDish.getReviews());
                    break;
                }
            }
        }
        return null;
    }
}