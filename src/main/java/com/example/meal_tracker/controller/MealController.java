package com.example.meal_tracker.controller;

import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.repository.RepositoryException;
import com.example.meal_tracker.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/meals")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping
    public String getMeals(Model model) {
        System.out.println("Get all meals...");
        List<Meal> meals = mealService.getAllMeals();
        model.addAttribute("meals", meals);
        return "meals/list";
    }

//    @RequestMapping(value = "/by-date/{date}", method = RequestMethod.GET)
//    public List<Meal> getMealsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        System.out.println("Get meals by date..." + date.toString());
//        return mealService.getMealsByDate(date);
//    }
//
    @GetMapping("/add")
    public String showAddForm(Model model) {
        System.out.println("Add form...");
        model.addAttribute("meal", new Meal());
        return "meals/add";
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateMeal(@PathVariable Long id, @RequestBody Meal meal) {
//        System.out.println("Update meal...");
//        Meal currentMeal = mealService.getMealById(id);
//        if (currentMeal == null) {
//            return new ResponseEntity<String>("Meal not found", HttpStatus.NOT_FOUND);
//        }
//        currentMeal.setName(meal.getName());
//        currentMeal.setDescription(meal.getDescription());
//        currentMeal.setCalories(meal.getCalories());
//        currentMeal.setDate(meal.getDate());
//        Meal updatedMeal = mealService.updateMeal(currentMeal);
//        return new ResponseEntity<Meal>(updatedMeal, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<?> getMealById(@PathVariable Long id) {
//        System.out.println("Get meal by id..." + id.toString());
//        Meal meal = mealService.getMealById(id);
//        if (meal == null)
//            return new ResponseEntity<String>("Meal not found", HttpStatus.NOT_FOUND);
//        else
//            return new ResponseEntity<Meal>(meal, HttpStatus.OK);
//    }
//
//    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteMeal(@PathVariable Long id) {
//        System.out.println("Deleting meal..." + id.toString());
//        try{
//            mealService.deleteMeal(id);
//            return new ResponseEntity<Meal>(HttpStatus.OK);
//        }catch (RepositoryException ex){
//            System.out.println("Delete meal exception");
//            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//    }

    @ExceptionHandler(RepositoryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userError(RepositoryException e) {
        return e.getMessage();
    }
}
