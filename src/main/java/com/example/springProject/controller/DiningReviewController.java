package com.example.springProject.controller;

import com.example.springProject.repository.RestaurantRepository;
import com.example.springProject.repository.DiningReviewRepository;
import com.example.springProject.repository.UsersRepository;
import com.example.springProject.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diningReview")
public class DiningReviewController {

    private final DiningReviewRepository diningReviewRepository;

    @Autowired
    public DiningReviewController(DiningReviewRepository diningReviewRepository, UsersRepository usersRepository, RestaurantRepository restaurantRepository){
        this.diningReviewRepository = diningReviewRepository;
    }

    @GetMapping("/reviews")
    public List<DiningReview> getAllDiningReviews(){
        return diningReviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<DiningReview> getDiningReviewByRestaurantId(@PathVariable("id") Long id){
        return diningReviewRepository.findByRestaurantId(id);}

    @PostMapping("/newReview")
    public DiningReview createNewDiningReview(@RequestBody DiningReview diningReview){
        return diningReviewRepository.save(diningReview);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public DiningReview updateDiningReviewStatus (@PathVariable("id") Long id, @RequestBody DiningReview diningReview) {
        return diningReviewRepository.findById(id)
                .map(reviewStatus -> {
                    reviewStatus.setReviewStatus(diningReview.getReviewStatus());
                    return diningReviewRepository.save(reviewStatus);
                })
                .orElseGet(() -> {
                    return diningReviewRepository.save(diningReview);
                });
    }

    @DeleteMapping("delete/{id}")
    public String deleteDiningReview (@PathVariable("id") Long id){
        diningReviewRepository.deleteById(id);
        return "Successfully delete dining review: " + id;
    }

}