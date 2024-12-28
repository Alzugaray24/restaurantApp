package com.example.config.initializers;

import com.example.repositories.MenuRepository;
import com.example.repositories.RestaurantRepository;
import com.example.services.menu.AddDishToMenuService;
import com.example.services.restaurant.AddRestaurantService;
import com.example.services.restaurant.RemoveRestaurantService;
import com.example.services.restaurant.ShowRestaurantService;
import com.example.services.restaurant.UpdateRestaurantService;

public class ServiceInitializer {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    public final AddRestaurantService addRestaurantService;
    public final RemoveRestaurantService removeRestaurantService;
    public final ShowRestaurantService showRestaurantService;
    public final UpdateRestaurantService updateRestaurantService;
    public final AddDishToMenuService addDishToMenuService;

    public ServiceInitializer() {
        this.restaurantRepository = RestaurantRepository.getInstance();
        this.menuRepository = MenuRepository.getInstance();
        this.addRestaurantService = new AddRestaurantService(restaurantRepository);
        this.removeRestaurantService = new RemoveRestaurantService(restaurantRepository);
        this.showRestaurantService = new ShowRestaurantService(restaurantRepository);
        this.updateRestaurantService = new UpdateRestaurantService(restaurantRepository);
        this.addDishToMenuService = new AddDishToMenuService(menuRepository);
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }
}