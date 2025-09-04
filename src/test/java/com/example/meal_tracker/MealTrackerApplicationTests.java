package com.example.meal_tracker;

import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.service.MealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MealTrackerApplicationTests {
	@Autowired
	MealService mealService;
	/*Test for add meal method*/
	@Test
	@Transactional
	@Rollback
	void testSaveMeal() {
		Meal meal1 = new Meal("ovaz", "low calorie", 100, LocalDateTime.now());
		mealService.saveMeal(meal1);
		Meal savedMeal = mealService.getMealById(meal1.getId());

		assertNotNull(savedMeal);
		assertNotNull(savedMeal.getId());
		assertThat(savedMeal.getName()).isEqualTo(meal1.getName());
		assertThat(savedMeal.getDescription()).isEqualTo(meal1.getDescription());
		assertThat(savedMeal.getCalories()).isEqualTo(meal1.getCalories());
		assertThat(savedMeal.getDate()).isEqualTo(meal1.getDate());
	}

	@Test
	void testGetByDate() {
		LocalDate date = LocalDate.of(2025,8,27);
		List<Meal> meals = mealService.getMealsByDate(date);
		assertThat(meals.size()).isEqualTo(2);
	}

}
