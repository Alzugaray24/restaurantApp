package com.example.config.initializers;

import com.example.repositories.MenuRepository;
import com.example.repositories.RestaurantRepository;
import com.example.services.menu.AddDishToMenuService;
import com.example.services.menu.RemoveDishFromMenuService;
import com.example.services.menu.UpdateDishFromMenuService;
import com.example.services.restaurant.AddRestaurantService;
import com.example.services.restaurant.RemoveRestaurantService;
import com.example.services.restaurant.ShowRestaurantService;
import com.example.services.restaurant.UpdateRestaurantService;

public class ServiceInitializer {
    private final RestaurantRepository restaurantRepository;
    public final AddRestaurantService addRestaurantService;
    public final RemoveRestaurantService removeRestaurantService;
    public final ShowRestaurantService showRestaurantService;
    public final UpdateRestaurantService updateRestaurantService;
    public final AddDishToMenuService addDishToMenuService;
    public final RemoveDishFromMenuService removeDishFromMenuService;
    public final UpdateDishFromMenuService updateDishFromMenuService;

    public ServiceInitializer() {
        this.restaurantRepository = RestaurantRepository.getInstance();
        MenuRepository menuRepository = MenuRepository.getInstance();
        this.addRestaurantService = new AddRestaurantService(restaurantRepository);
        this.removeRestaurantService = new RemoveRestaurantService(restaurantRepository);
        this.showRestaurantService = new ShowRestaurantService(restaurantRepository);
        this.updateRestaurantService = new UpdateRestaurantService(restaurantRepository);
        this.addDishToMenuService = new AddDishToMenuService(menuRepository);
        this.removeDishFromMenuService = new RemoveDishFromMenuService(menuRepository);
        this.updateDishFromMenuService = new UpdateDishFromMenuService(menuRepository);
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }
}