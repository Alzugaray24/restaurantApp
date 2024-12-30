package com.example.factories;

import com.example.models.Review;

public interface IReviewFactory {
    Review createReview(String comment, Integer score);
}