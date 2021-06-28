package com.rv.ek.nutrition.repositories;

import com.rv.ek.nutrition.models.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Integer> {

}
