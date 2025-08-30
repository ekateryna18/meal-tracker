package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMealRepo extends JpaRepository<Meal, Long> {
}
