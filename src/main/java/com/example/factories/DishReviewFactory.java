package com.example.factories;

import com.example.models.Dish;
import com.example.models.Review;

public class DishReviewFactory implements IReviewFactory {
    private Dish dish;

    public DishReviewFactory(Dish dish) {
        this.dish = dish;
    }

    @Override
    public Review createReview(String comment, Integer score) {
        return new Review(comment, score, dish);
    }
}