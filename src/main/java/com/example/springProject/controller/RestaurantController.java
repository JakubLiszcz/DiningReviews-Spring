package com.example.springProject.controller;

import com.example.springProject.repository.RestaurantRepository;
import com.example.springProject.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    @GetMapping("/{name}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("name") String name) { return restaurantRepository.findByName(name); }

    @PostMapping("/newRestaurant")
    public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Restaurant updateRestaurantOverallScore (@PathVariable("id") Long id, @RequestBody Restaurant restaurant) {
        return restaurantRepository.findById(id)
                .map(peanutScore -> {
                    peanutScore.setPeanutScore(restaurant.getPeanutScore());
                    return restaurantRepository.save(peanutScore);
                })
                .map(eggScore -> {
                    eggScore.setEggScore(restaurant.getEggScore());
                    return restaurantRepository.save(eggScore);
                })
                .map(dairyScore -> {
                    dairyScore.setDairyScore(restaurant.getDairyScore());
                    restaurant.setOverallScore(calculateOverallScore(restaurant));
                    return restaurantRepository.save(dairyScore);
                })
                .orElseGet(() -> {
                    return restaurantRepository.save(restaurant);
                });

    }

    private Integer calculateOverallScore (Restaurant restaurant){
        return restaurant.getDairyScore() + restaurant.getEggScore() + restaurant.getPeanutScore() / 3;
    }

    @DeleteMapping("delete/{id}")
    public String deleteRestaurant (@PathVariable("id") Long id){
        restaurantRepository.deleteById(id);
        return "Successfully delete restaurant: " + id;
    }
}
