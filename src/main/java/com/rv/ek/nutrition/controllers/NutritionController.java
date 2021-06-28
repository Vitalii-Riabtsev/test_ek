package com.rv.ek.nutrition.controllers;

import com.rv.ek.nutrition.models.*;
import com.rv.ek.nutrition.exceptions.CustomerNotFoundException;
import com.rv.ek.nutrition.repositories.*;
import com.rv.ek.nutrition.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class NutritionController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MealPlansRepository mealPlansRepository;

    @Autowired
    private MealPlanNutritionRepository mealPlanNutritionRepository;

    @Autowired
    private ScheduleNutritionRepository scheduleNutritionRepository;

    @Autowired
    private TrackNutritionRepository trackNutritionRepository;

    @Autowired
    private NutritionService nutritionService;

    public NutritionController() {
        super();
    }

    @GetMapping
    public List<Customer> getAllUsers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @GetMapping("/{customer_id}")
    public Customer findById(@PathVariable(value = "customer_id") final long customerID) {
        return customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));
    }

    @GetMapping("/{customer_id}/meal_plans")
    public List<MealPlan> getCustomerMealPlans(@PathVariable(value = "customer_id") final long customerID) {
        return mealPlansRepository.findAllByCustomerID(customerID);
    }

    @GetMapping("/{customer_id}/meal_plans/{meal_plan_id}")
    public MealPlan getCustomerMealPlans(@PathVariable(value = "customer_id") final long customerID,
                                         @PathVariable(value = "meal_plan_id") final long mealPlanID) {
        return mealPlansRepository.findByIdAndCustomerID(mealPlanID, customerID);
    }

    @GetMapping("/{customer_id}/meal_plan_by_day")
    public MealPlan getCustomerMealPlans(@PathVariable(value = "customer_id") final long customerID,
                                         @RequestParam(value = "date")
                                         @DateTimeFormat(pattern = "yyyy-MM-dd")
                                         @NotNull final Date date) {
        return nutritionService.getCustomerMealPlanForDate(customerID, date);
    }

    @DeleteMapping("/{customer_id}/meal_plans/{meal_plan_id}")
    public void deleteCustomerMealPlans(@PathVariable(value = "customer_id") final long customerID,
                                        @PathVariable(value = "meal_plan_id") final long mealPlanID) {

        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));
        
        mealPlansRepository.deleteById(mealPlanID);
    }

    @PostMapping(consumes = "application/json", path = "/{customer_id}/meal_plans")
    public MealPlan saveCustomerMealPlan(@PathVariable(value = "customer_id") final long customerID,
                                         @RequestBody @Valid MealPlan mealPlan) {
        if (customerID != mealPlan.getCustomerID()) {
            mealPlan.setCustomerID(customerID);
        }
        return mealPlansRepository.save(mealPlan);
    }

    @GetMapping("/{customer_id}/meal_plans/{meal_plan_id}/nutrition")
    public List<MealPlanNutrition> getCustomerMealPlanNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                                @PathVariable(value = "meal_plan_id") final long mealPlanID,
                                                                @RequestParam(value = "all", required = false) final boolean all) {
        if (all) {
            return mealPlanNutritionRepository.findAllByMealPlanIDAndCustomerID(mealPlanID, customerID);
        }
        return mealPlanNutritionRepository.getCurrentMealPlanNutritionList(mealPlanID, customerID);
    }

    @GetMapping("/{customer_id}/meal_plans/{meal_plan_id}/nutrition/{nutrition_id}")
    public MealPlanNutrition getCustomerMealPlanNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                          @PathVariable(value = "meal_plan_id") final long mealPlanID,
                                                          @PathVariable(value = "nutrition_id") final int nutritionID) {
        return mealPlanNutritionRepository.findByIdAndMealPlanIDAndCustomerID(mealPlanID, customerID, nutritionID);
    }

    @PostMapping(consumes = "application/json", path = "/{customer_id}/meal_plans/{meal_plan_id}/nutrition")
    public MealPlanNutrition saveCustomerMealPlanNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                           @PathVariable(value = "meal_plan_id") final long mealPlanID,
                                                           @RequestParam(value = "apply") final boolean apply,
                                                           @RequestBody @Valid MealPlanNutrition mealPlanNutrition) {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));

        if (mealPlanID != mealPlanNutrition.getMealPlanID()) {
            mealPlanNutrition.setMealPlanID(mealPlanID);
        }

        return nutritionService.saveCustomerMealPlanNutrition(apply, mealPlanNutrition);
    }

    @GetMapping("/{customer_id}/schedule_nutrition")
    public List<ScheduleNutrition> getCustomerScheduleNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                                @RequestParam(value = "all", required = false) final boolean all) {
        if (all) {
            return scheduleNutritionRepository.findAllByCustomerID(customerID);
        }
        return scheduleNutritionRepository.getCurrentScheduleNutritionList(customerID);
    }

    @GetMapping("/{customer_id}/schedule_nutrition_by_day")
    public ScheduleNutrition getCustomerScheduleNutritionForDate(@PathVariable(value = "customer_id") final long customerID,
                                                                 @RequestParam(value = "date")
                                                                 @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                 @NotNull final Date date) {
        return nutritionService.getCustomerScheduleNutritionForDate(customerID, date);
    }

    @GetMapping("/{customer_id}/schedule_nutrition/{schedule_id}")
    public ScheduleNutrition getCustomerScheduleNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                          @PathVariable(value = "schedule_id") final long scheduleID) {
        return scheduleNutritionRepository.findByIdAndCustomerID(scheduleID, customerID);
    }

    @PostMapping(consumes = "application/json", path = "/{customer_id}/schedule_nutrition")
    public ScheduleNutrition saveCustomerScheduleNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                           @RequestParam(value = "apply") final boolean apply,
                                                           @RequestBody @Valid ScheduleNutrition scheduleNutrition) {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));

        if (customerID != scheduleNutrition.getCustomerID()) {
            scheduleNutrition.setCustomerID(customerID);
        }

        return nutritionService.saveCustomerScheduleNutrition(apply, scheduleNutrition);
    }

    @GetMapping("/{customer_id}/track_nutrition")
    public List<TrackNutrition> getTrackNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                  @RequestParam(value = "date", required = false)
                                                  @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                  final Date trackDate) {
        if (trackDate == null) {
            return trackNutritionRepository.findAllByCustomerID(customerID);
        }
        return trackNutritionRepository.findByCustomerIDAndTrackDate(customerID, trackDate);
    }

    @GetMapping("/{customer_id}/track_nutrition/{track_nutrition_id}")
    public TrackNutrition getTrackNutritionByID(@PathVariable(value = "customer_id") final long customerID,
                                                @PathVariable(value = "track_nutrition_id") final long trackNutritionID) {

        return trackNutritionRepository.findByIdAndCustomerID(trackNutritionID, customerID);
    }

    @PostMapping(consumes = "application/json", path = "/{customer_id}/track_nutrition")
    public TrackNutrition saveCustomerTrackNutrition(@PathVariable(value = "customer_id") final long customerID,
                                                     @RequestBody @Valid TrackNutrition trackNutrition) {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));

        if (customerID != trackNutrition.getCustomerID()) {
            trackNutrition.setCustomerID(customerID);
        }

        return nutritionService.saveCustomerTrackNutrition(trackNutrition);
    }

    @GetMapping("/{customer_id}/nutrition_result")
    public List<CustomerNutritionResultData> getCustomerNutritionResultDataByDate(@PathVariable(value = "customer_id") final long customerID,
                                                                                  @RequestParam(value = "date")
                                                                                  @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                                                  @NotNull final Date date) {
        return nutritionService.getCustomerNutritionResultDataByDate(customerID, date);
    }
}
