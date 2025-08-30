package com.example.meal_tracker.controller;

import com.example.meal_tracker.model.Meal;
import com.example.meal_tracker.repository.RepositoryException;
import com.example.meal_tracker.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {
    @Autowired
    private MealService mealService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Meal> getMeals(Model model) {
        System.out.println("Get all meals...");
        return mealService.getAllMeals();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Meal addMeal(@RequestBody Meal meal) {
        Meal savedMeal = mealService.saveMeal(meal);
        return savedMeal;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMealById(@PathVariable Long id) {
        System.out.println("Get meal by id..." + id.toString());
        Meal meal = mealService.getMealById(id);
        if (meal == null)
            return new ResponseEntity<String>("Meal not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Meal>(meal, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMeal(@PathVariable Long id) {
        System.out.println("Deleting meal..." + id.toString());
        try{
            mealService.deleteMeal(id);
            return new ResponseEntity<Meal>(HttpStatus.OK);
        }catch (RepositoryException ex){
            System.out.println("Delete meal exception");
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(RepositoryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userError(RepositoryException e) {
        return e.getMessage();
    }
}
