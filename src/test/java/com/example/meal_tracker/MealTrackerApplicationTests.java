package com.example.meal_tracker;

import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.service.MealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MealTrackerApplicationTests {
	@Autowired
	MealService mealService;
	@Test
	void testSaveMeal() {
		Meal meal1 = new Meal("iaurt", "low calorie", 100, LocalDateTime.now());
		mealService.saveMeal(meal1);
		Meal savedMeal = mealService.getMealById(meal1.getId());
		assertThat(savedMeal.getName()).isEqualTo("iaurt");
		assertThat(savedMeal.getCalories()).isEqualTo(100);
	}
	@Test
	void contextLoads() {
	}

}
