package com.example.models;

import java.util.List;

public class Restaurant {
    private String name;
    private String direction;
    private Integer available;
    private Menu menu;
    private List<Review> reviews;
    private Double raiting;

    public Restaurant() {
    }

    public Restaurant(String name, String direction, Integer available, Menu menu, List<Review> reviews, Double raiting) {
        this.name = name;
        this.direction = direction;
        this.available = available;
        this.menu = menu;
        this.reviews = reviews;
        this.raiting = raiting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Double getRaiting() {
        return raiting;
    }

    public void setRaiting(Double raiting) {
        this.raiting = raiting;
    }
}
