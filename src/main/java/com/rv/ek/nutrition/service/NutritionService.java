package com.rv.ek.nutrition.service;

import com.rv.ek.nutrition.NutritionHelper;
import com.rv.ek.nutrition.exceptions.MealPlanNotFoundException;
import com.rv.ek.nutrition.exceptions.ScheduleNotDefinedException;
import com.rv.ek.nutrition.models.*;
import com.rv.ek.nutrition.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NutritionService {
    @Autowired
    private MealPlanNutritionRepository mealPlanNutritionRepository;

    @Autowired
    private MealPlansRepository mealPlansRepository;

    @Autowired
    private ScheduleNutritionRepository scheduleNutritionRepository;

    @Autowired
    private TrackNutritionRepository trackNutritionRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private NutritionRepository nutritionRepository;

    public MealPlanNutrition saveCustomerMealPlanNutrition(boolean apply,
                                                           MealPlanNutrition mealPlanNutrition) {

        Date startDate = apply ? new Date() : NutritionHelper.getTomorrowDate();
        mealPlanNutrition.setStartDate(startDate);

        MealPlanNutrition existNutrition = mealPlanNutritionRepository
                .findByMealPlanIDAndNutritionIDAndMealIDAndStartDate(mealPlanNutrition.getMealPlanID()
                        , mealPlanNutrition.getNutritionID()
                        , mealPlanNutrition.getMealID()
                        , mealPlanNutrition.getStartDate());

        if(existNutrition==null) {
            mealPlanNutrition.setId(0);
        } else {
            mealPlanNutrition.setId(existNutrition.getId());
        }

        return mealPlanNutritionRepository.save(mealPlanNutrition);
    }

    public TrackNutrition saveCustomerTrackNutrition(TrackNutrition trackNutrition) {
        TrackNutrition existTrackNutrition = trackNutritionRepository
                .findByCustomerIDAndNutritionIDAndMealIDAndTrackDate(trackNutrition.getCustomerID()
                        , trackNutrition.getNutritionID()
                        , trackNutrition.getMealID()
                        , trackNutrition.getTrackDate());

        if(existTrackNutrition==null) {
            trackNutrition.setId(0);
        } else {
            trackNutrition.setId(existTrackNutrition.getId());
        }

        return trackNutritionRepository.save(trackNutrition);
    }

    public ScheduleNutrition saveCustomerScheduleNutrition(boolean apply,
                                                           ScheduleNutrition scheduleNutrition) {
        Date startDate = apply ? new Date() : NutritionHelper.getTomorrowDate();
        scheduleNutrition.setStartDate(startDate);

        ScheduleNutrition existScheduleNutrition = scheduleNutritionRepository
                .findByCustomerIDAndDayIDAndStartDate(scheduleNutrition.getCustomerID()
                        , scheduleNutrition.getDayID()
                        , scheduleNutrition.getStartDate());

        if(existScheduleNutrition==null) {
            scheduleNutrition.setId(0);
        } else {
            scheduleNutrition.setId(existScheduleNutrition.getId());
        }

        return scheduleNutritionRepository.save(scheduleNutrition);
    }

    public ScheduleNutrition getCustomerScheduleNutritionForDate(long customerID, @NotNull Date date) {
        int isoDay = WeekDay.isoDay(date);
        List<ScheduleNutrition> currentSchedule = scheduleNutritionRepository.getCurrentScheduleNutritionList(customerID);
        return currentSchedule.stream().filter(s -> s.getDayID() == isoDay).findAny().orElseThrow(() -> new ScheduleNotDefinedException(isoDay));
    }

    public MealPlan getCustomerMealPlanForDate(long customerID, @NotNull Date date) {
        int isoDay = WeekDay.isoDay(date);
        List<ScheduleNutrition> currentSchedule = scheduleNutritionRepository.getCurrentScheduleNutritionList(customerID);
        ScheduleNutrition scheduleNutrition = currentSchedule.stream().filter(s -> s.getDayID() == isoDay).findAny().orElseThrow(() -> new ScheduleNotDefinedException(isoDay));
        long mealPlanID = scheduleNutrition.getMealPlanID();

        return mealPlansRepository.findById(mealPlanID).orElseThrow(() -> new MealPlanNotFoundException(mealPlanID));
    }

    public List<CustomerNutritionResultData> getCustomerNutritionResultDataByDate(long customerID, @NotNull Date date) {
        ScheduleNutrition scheduleNutrition = getCustomerScheduleNutritionForDate(customerID, date);
        long mealPlanID = scheduleNutrition.getMealPlanID();

        List<MealPlanNutrition> allTargetNutrition = mealPlanNutritionRepository.getCurrentMealPlanNutritionList(customerID, mealPlanID);
        List<TrackNutrition> allConsumedNutrition = trackNutritionRepository.findByCustomerIDAndTrackDate(customerID, date);

        boolean isWorkoutDay = (scheduleNutrition.getFunctionalFlagMask() & FunctionalFlag.WORKOUT.id) != 0;


        List<Meal> availableMeals = (List<Meal>) mealRepository.findAll();

        List<Meal> mealsToCalculate = availableMeals.stream()
                .filter(m -> (m.getFunctionalFlagMask() & FunctionalFlag.WORKOUT.id) == 0
                        || (isWorkoutDay && (m.getFunctionalFlagMask() & FunctionalFlag.WORKOUT.id) != 0))
                .collect(Collectors.toList());

        List<CustomerNutritionResultData> resultData = new ArrayList<>();
        for (Meal meal : mealsToCalculate) {
            List<MealPlanNutrition> targetNutrition = allTargetNutrition.stream()
                    .filter(n -> n.getMealID() == meal.getId())
                    .collect(Collectors.toList());
            List<TrackNutrition> consumedNutrition = allConsumedNutrition.stream()
                    .filter(n -> n.getMealID() == meal.getId())
                    .collect(Collectors.toList());

            int sumTargetNutrition = targetNutrition.stream()
                    .map(MealPlanNutrition::getValue)
                    .reduce(0, Integer::sum);

            long score = 0;
            if (sumTargetNutrition != 0) {
                int totalConsumedNutrition = consumedNutrition.stream()
                        .map(TrackNutrition::getValue)
                        .reduce(0, Integer::sum);

                long d = Math.abs(sumTargetNutrition - totalConsumedNutrition)/sumTargetNutrition;
                score = Math.round(5 * Math.exp(-2.3 * d));
            }

            CustomerNutritionResultData customerNutritionResultData = new CustomerNutritionResultData(meal
                    , targetNutrition
                    , consumedNutrition
                    , score);

            resultData.add(customerNutritionResultData);
        }

        return resultData;
    }

    @Cacheable("meals")
    public List<Meal> findAllMeals() {
        return (List<Meal>) mealRepository.findAll();
    }

    @Cacheable("nutrients")
    public List<Nutrition> findAllNutrients() {
        return (List<Nutrition>) nutritionRepository.findAll();
    }
}
