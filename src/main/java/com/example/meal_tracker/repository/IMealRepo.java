package com.example.meal_tracker.repository;

import com.example.meal_tracker.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IMealRepo extends JpaRepository<Meal, Long> {
    List<Meal> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
