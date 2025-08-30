package com.example.meal_tracker.service;

import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.repository.IMealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService implements IMealService {
    @Autowired private IMealRepo mealRepo;

    @Override
    public List<Meal> getAllMeals(){
        return mealRepo.findAll();
    }

    @Override
    public Meal getMealById(Long id) {
        return mealRepo.findById(id).orElse(null);
    }

    @Override
    public List<Meal> getMealsByDate(String date) {
        return List.of();
    }

    @Override
    public Meal saveMeal(Meal meal) {
        return mealRepo.save(meal);
    }

    @Override
    public void updateMeal(Meal meal) {
    }

    @Override
    public void deleteMeal(Long id) {
        mealRepo.deleteById(id);
    }
}
