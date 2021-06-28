package com.rv.ek.nutrition.repositories;

import com.rv.ek.nutrition.models.ScheduleNutrition;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleNutritionRepository extends CrudRepository<ScheduleNutrition, Long> {

    List<ScheduleNutrition> findAllByCustomerID(long customerID);

    ScheduleNutrition findByIdAndCustomerID(long id,
                                            long customerID);

    @Query("" +
            " SELECT sn.id" +
            "      , sn.customer_id" +
            "      , sn.meal_plan_id" +
            "      , sn.day_id" +
            "      , sn.functional_flag_mask" +
            "      , sn.start_date" +
            "   FROM (SELECT MAX(c.start_date) last_updated_date" +
            "              , c.customer_id" +
            "              , c.day_id" +
            "         FROM schedule_nutrition c" +
            "        WHERE c.customer_id = :customer_id" +
            "          AND c.start_date <= CURRENT_DATE" +
            "        GROUP BY c.customer_id, c.day_id" +
            "      ) cur" +
            "   JOIN schedule_nutrition sn ON (sn.customer_id = cur.customer_id " +
            "                                  AND sn.day_id = cur.day_id" +
            "                                  AND sn.start_date = cur.last_updated_date)")
    List<ScheduleNutrition> getCurrentScheduleNutritionList(@Param("customer_id") long customerID);

    ScheduleNutrition findByCustomerIDAndDayIDAndStartDate(long customerID, int dayID, Date startDate);
}
