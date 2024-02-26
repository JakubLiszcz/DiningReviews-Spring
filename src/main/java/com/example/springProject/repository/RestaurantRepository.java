package com.example.springProject.repository;

import com.example.springProject.model.Restaurant;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Boolean existsByNameAndZipCode(String name, String zipCode);
    List<Restaurant> findByZipCodeAndOverallScoreIsNotNullOrderByNameDesc(String zipCode);
    Optional<Restaurant> findByName(String name);
}
