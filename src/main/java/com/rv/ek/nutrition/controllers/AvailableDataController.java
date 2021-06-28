package com.rv.ek.nutrition.controllers;

import com.rv.ek.nutrition.models.*;
import com.rv.ek.nutrition.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class AvailableDataController {

    private final NutritionService nutritionService;

    @Autowired
    public AvailableDataController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @GetMapping
    public Map<String, Object> getAllData() {
        Map<String, Object> res = new HashMap<>();
        List<Nutrition> nutritionList = nutritionService.findAllNutrients();
        res.put("nutritionList", nutritionList);

        List<Meal> mealList = nutritionService.findAllMeals();
        res.put("mealList", mealList);

        res.put("weekDayList", WeekDay.values());

        res.put("functionalFlagList", FunctionalFlag.values());
        return res;
    }
}
