package com.rv.ek.nutrition.repositories;

import com.rv.ek.nutrition.models.TrackNutrition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TrackNutritionRepository extends CrudRepository<TrackNutrition, Long> {
    List<TrackNutrition> findAllByCustomerID(long customerID);

    TrackNutrition findByIdAndCustomerID(long id, long customerID);

    List<TrackNutrition> findByCustomerIDAndTrackDate(long customerID, Date trackDate);

    TrackNutrition findByCustomerIDAndNutritionIDAndMealIDAndTrackDate(long customerID, int nutritionID, int mealID, Date trackDate);
}
