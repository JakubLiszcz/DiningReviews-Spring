package com.example.springProject.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;
    @Getter @Setter
    private String zipCode;

    //Scores
    private int peanutScore;
    private int peanutReviewAmount;
    private int eggScore;
    private int eggReviewAmount;
    private int dairyScore;
    private int dairyReviewAmount;
    private int overallScore;



    public Restaurant(String name){this.name = name;}
    //PEANUT
    public Integer getPeanutScore(){
        if (peanutScore > 0)
            return this.peanutScore/this.peanutReviewAmount;
        else
            return 0;
    }
    public void setPeanutScore(int peanutScore){
        setPeanutReviewAmount(this.getPeanutReviewAmount() + 1);
        this.peanutScore += peanutScore;
    }
    public Integer getPeanutReviewAmount(){
        return this.peanutReviewAmount;
    }
    public void setPeanutReviewAmount(int peanutReviewAmount){
        this.peanutReviewAmount = peanutReviewAmount;
    }

    //EGG
    public Integer getEggScore(){
        if (eggScore > 0)
            return this.eggScore/this.eggReviewAmount;
        else
            return 0;
    }
    public void setEggScore(int eggScore){
        setEggReviewAmount(this.getEggReviewAmount() + 1);
        this.eggScore += eggScore;
    }
    public Integer getEggReviewAmount(){
        return this.eggReviewAmount;
    }
    public void setEggReviewAmount(int eggReviewAmount){
        this.eggReviewAmount = eggReviewAmount;
    }


    //DAIRY
    public Integer getDairyScore(){
        if (dairyScore > 0)
            return this.dairyScore/this.dairyReviewAmount;
        else
            return 0;
    }
    public void setDairyScore(int dairyScore){
        setDairyReviewAmount(this.getDairyReviewAmount() + 1);
        this.dairyScore += dairyScore;
    }
    public Integer getDairyReviewAmount(){
        return this.dairyReviewAmount;
    }
    public void setDairyReviewAmount(int dairyReviewAmount){
        this.dairyReviewAmount = dairyReviewAmount;
    }


    public Integer getOverallScore(){
        if (dairyScore > 0 || eggScore > 0 || peanutScore >0)
            return (this.dairyScore+this.peanutScore+this.eggScore)/(this.dairyReviewAmount+this.peanutReviewAmount+this.eggReviewAmount);
        else
            return 0;
    }
    public void setOverallScore(int overallScore){
        this.overallScore = overallScore;
    }

}
