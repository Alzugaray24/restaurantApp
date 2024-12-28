package com.example.services.review;

import com.example.factories.DishReviewFactory;
import com.example.factories.RestaurantReviewFactory;
import com.example.models.Dish;
import com.example.models.Restaurant;
import com.example.models.Review;
import com.example.repositories.DishRepository;
import com.example.repositories.RestaurantRepository;

public class AddReviewService {
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public AddReviewService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void addReviewToDish(String dishName, String comment, Integer score) {
        Dish dish = dishRepository.findByName(dishName);
        if (dish == null) {
            throw new IllegalArgumentException("Plato no encontrado.");
        }

        DishReviewFactory dishReviewFactory = new DishReviewFactory(dish);
        Review review = dishReviewFactory.createReview(comment, score);
        dish.getReviews().add(review);
    }

    public void addReviewToRestaurant(String restaurantName, String comment, Integer score) {
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurante no encontrado.");
        }

        RestaurantReviewFactory restaurantReviewFactory = new RestaurantReviewFactory(restaurant);
        Review review = restaurantReviewFactory.createReview(comment, score);
        restaurant.getReviews().add(review);
    }
}