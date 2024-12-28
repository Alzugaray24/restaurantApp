package com.example.factories;

import com.example.models.Review;

public interface ReviewFactory {
    Review createReview(String comment, Integer score);
}