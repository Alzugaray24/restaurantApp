package com.example.services.review;

import com.example.models.Dish;
import com.example.models.Restaurant;
import com.example.models.Review;
import com.example.repositories.DishRepository;
import com.example.repositories.RestaurantRepository;

import java.util.List;

public class ListReviewService {
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public ListReviewService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Review> listReviewsForDish(String dishName) {
        Dish dish = dishRepository.findByName(dishName);
        if (dish == null) {
            throw new IllegalArgumentException("Dish not found.");
        }
        return dish.getReviews();
    }

    public List<Review> listReviewsForRestaurant(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found.");
        }
        return restaurant.getReviews();
    }
}