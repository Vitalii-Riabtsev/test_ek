package com.rv.ek.nutrition.repositories;

import com.rv.ek.nutrition.models.Nutrition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionRepository extends CrudRepository<Nutrition, Integer> {
}
