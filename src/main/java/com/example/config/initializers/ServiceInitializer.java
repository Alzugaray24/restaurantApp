package com.example.config.initializers;

import com.example.repositories.DishRepository;
import com.example.repositories.MenuRepository;
import com.example.repositories.RestaurantRepository;
import com.example.services.menu.AddDishToMenuService;
import com.example.services.menu.RemoveDishFromMenuService;
import com.example.services.menu.UpdateDishFromMenuService;
import com.example.services.restaurant.AddRestaurantService;
import com.example.services.restaurant.RemoveRestaurantService;
import com.example.services.restaurant.ShowRestaurantService;
import com.example.services.restaurant.UpdateRestaurantService;
import com.example.services.review.AddReviewService;
import com.example.services.review.ListReviewService;
import com.example.services.review.CalculateAverageRatingService;

public class ServiceInitializer {
    private final RestaurantRepository restaurantRepository;
    public final AddRestaurantService addRestaurantService;
    public final RemoveRestaurantService removeRestaurantService;
    public final ShowRestaurantService showRestaurantService;
    public final UpdateRestaurantService updateRestaurantService;
    public final AddDishToMenuService addDishToMenuService;
    public final RemoveDishFromMenuService removeDishFromMenuService;
    public final UpdateDishFromMenuService updateDishFromMenuService;
    public final AddReviewService addReviewService;
    public final ListReviewService listReviewService;
    public final CalculateAverageRatingService calculateAverageRatingService;

    public ServiceInitializer() {
        this.restaurantRepository = RestaurantRepository.getInstance();
        MenuRepository menuRepository = MenuRepository.getInstance();
        DishRepository dishRepository = DishRepository.getInstance();
        this.addRestaurantService = new AddRestaurantService(restaurantRepository);
        this.removeRestaurantService = new RemoveRestaurantService(restaurantRepository);
        this.showRestaurantService = new ShowRestaurantService(restaurantRepository);
        this.updateRestaurantService = new UpdateRestaurantService(restaurantRepository);
        this.addDishToMenuService = new AddDishToMenuService(menuRepository);
        this.removeDishFromMenuService = new RemoveDishFromMenuService(menuRepository);
        this.updateDishFromMenuService = new UpdateDishFromMenuService(menuRepository);
        this.addReviewService = new AddReviewService(dishRepository, restaurantRepository);
        this.listReviewService = new ListReviewService(dishRepository, restaurantRepository);
        this.calculateAverageRatingService = new CalculateAverageRatingService(dishRepository, restaurantRepository);
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }
}