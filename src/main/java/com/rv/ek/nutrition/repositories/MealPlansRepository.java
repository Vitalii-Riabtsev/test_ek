package com.rv.ek.nutrition.repositories;

import com.rv.ek.nutrition.models.MealPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealPlansRepository extends CrudRepository<MealPlan, Long> {

    List<MealPlan> findAllByCustomerID(long customerID);

    MealPlan findByIdAndCustomerID(long id, long customerID);
}
