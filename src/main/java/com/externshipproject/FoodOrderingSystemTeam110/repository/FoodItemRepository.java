package com.externshipproject.FoodOrderingSystemTeam110.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.externshipproject.FoodOrderingSystemTeam110.model.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
	List<FoodItem> findByName(String name);
    FoodItem save(FoodItem foodItem);
    void deleteById(long id);
    @Query("SELECT f FROM FoodItem f JOIN f.restaurants r WHERE r.id = :restaurantId")
	List<FoodItem> findFoodItemsByRestaurantId(@Param("restaurantId")Long restaurantId);

    List<FoodItem> findByRestaurantsId(Long restaurantsID);
}