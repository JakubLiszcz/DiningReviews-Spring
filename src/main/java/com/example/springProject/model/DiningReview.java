package com.example.springProject.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DiningReview {
    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String submitterName;
    @Getter @Setter
    private Long restaurantId;
    @Getter @Setter
    private int peanutScore;
    @Getter @Setter
    private int eggScore;
    @Getter @Setter
    private int dairyScore;
    @Getter @Setter
    private String comment;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus;

}
