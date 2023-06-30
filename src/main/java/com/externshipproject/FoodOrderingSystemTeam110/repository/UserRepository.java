package com.externshipproject.FoodOrderingSystemTeam110.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.externshipproject.FoodOrderingSystemTeam110.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}