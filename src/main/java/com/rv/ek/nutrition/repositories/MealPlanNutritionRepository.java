package com.rv.ek.nutrition.repositories;

import com.rv.ek.nutrition.models.MealPlanNutrition;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MealPlanNutritionRepository extends CrudRepository<MealPlanNutrition, Long> {

    @Query("" +
            " SELECT mpn.id" +
            "      , mpn.meal_plan_id" +
            "      , mpn.meal_id" +
            "      , mpn.nutrition_id" +
            "      , mpn.value" +
            "      , mpn.start_date" +
            "   FROM meal_plan_nutrition mpn" +
            "   JOIN meal_plans mp USING(meal_plan_id)" +
            "  WHERE mpn.meal_plan_id = :meal_plan_id" +
            "    AND mp.customer_id = :customer_id")
    List<MealPlanNutrition> findAllByMealPlanIDAndCustomerID(@Param("meal_plan_id")long mealPlanID,
                                                             @Param("customer_id") long customerID);

    @Query("" +
            " SELECT mpn.id" +
            "      , mpn.meal_plan_id" +
            "      , mpn.meal_id" +
            "      , mpn.nutrition_id" +
            "      , mpn.value" +
            "      , mpn.start_date" +
            "   FROM (SELECT MAX(c.start_date) last_updated_date" +
            "              , c.meal_plan_id" +
            "              , c.meal_id" +
            "              , c.nutrition_id" +
            "         FROM meal_plan_nutrition c" +
            "        WHERE c.meal_plan_id = :meal_plan_id" +
            "          AND c.start_date >= CURRENT_DATE" +
            "        GROUP BY c.meal_plan_id, c.meal_id, c.nutrition_id" +
            "      ) cur" +
            "   JOIN meal_plan_nutrition mpn ON (mpn.meal_plan_id = cur.meal_plan_id " +
            "                                    AND mpn.meal_id = cur.meal_id" +
            "                                    AND mpn.nutrition_id = cur.nutrition_id" +
            "                                    AND mpn.start_date = cur.last_updated_date)" +
            "   JOIN meal_plans mp ON (mp.meal_plan_id = cur.meal_plan_id)" +
            "  WHERE mp.customer_id = :customer_id")
    List<MealPlanNutrition> getCurrentMealPlanNutritionList(@Param("meal_plan_id")long mealPlanID,
                                                            @Param("customer_id") long customerID);

    @Query("" +
            " SELECT mpn.id" +
            "      , mpn.meal_plan_id" +
            "      , mpn.meal_id" +
            "      , mpn.nutrition_id" +
            "      , mpn.value" +
            "      , mpn.start_date" +
            "   FROM meal_plan_nutrition mpn" +
            "   JOIN meal_plans mp USING(meal_plan_id)" +
            "  WHERE mpn.id = :id" +
            "    AND mpn.meal_plan_id = :meal_plan_id" +
            "    AND mp.customer_id = :customer_id")
    MealPlanNutrition findByIdAndMealPlanIDAndCustomerID(@Param("id")long id,
                                                         @Param("meal_plan_id")long mealPlanID,
                                                         @Param("customer_id") long customerID);

    MealPlanNutrition findByMealPlanIDAndNutritionIDAndMealIDAndStartDate(long mealPlanID,
                                                                          long nutritionID,
                                                                          int mealID,
                                                                          Date startDate);
}
