package com.example.services.review;

import com.example.models.Dish;
import com.example.models.Restaurant;
import com.example.models.Review;
import com.example.repositories.DishRepository;
import com.example.repositories.RestaurantRepository;

public class CalculateAverageRatingService {
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public CalculateAverageRatingService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public double calculateAverageRatingForDish(String dishName) {
        Dish dish = dishRepository.findByName(dishName);
        if (dish == null) {
            throw new IllegalArgumentException("Dish not found.");
        }
        return dish.getReviews().stream()
                .mapToInt(Review::getScore)
                .average()
                .orElse(0.0);
    }

    public double calculateAverageRatingForRestaurant(String restaurantName) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found.");
        }
        return restaurant.getReviews().stream()
                .mapToInt(Review::getScore)
                .average()
                .orElse(0.0);
    }
}