package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IMealService {
    List<Meal> getAllMeals();
    Meal getMealById(Long id);
    List<Meal> getMealsByDate(LocalDate date);
    Meal saveMeal(Meal meal);
    Meal updateMeal(Meal meal);
    void deleteMeal(Long id);
}
