package com.example.meal_tracker.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@jakarta.persistence.Entity
@Table(name = "meal")
public class Meal extends Entity<Integer> {
    private String name;
    private String description;
    private Integer calories;
    private LocalDateTime date;

    public Meal(String name, String description, Integer calories, LocalDateTime date) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.date = date;
    }
    public Meal(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
