package com.externshipproject.FoodOrderingSystemTeam110.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.externshipproject.FoodOrderingSystemTeam110.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	List<Restaurant> findByName(String name);

}