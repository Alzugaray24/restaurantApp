package com.example.models;

public class Review {
    private String comment;
    private Integer score;

    public Review() {
    }

    public Review(String user, String comment, Integer score) {
        this.comment = comment;
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
