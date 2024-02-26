package com.example.springProject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue
    @Setter @Getter
    private Long id;
    @Setter @Getter
    private String userName;
    @Setter @Getter
    private String firstName;
    @Setter @Getter
    private String city;
    @Setter @Getter
    private String state;
    @Setter @Getter
    private String zipCode;
    @Setter @Getter
    private Boolean peanutAllergies;
    @Setter @Getter
    private Boolean eggAllergies;
    @Setter @Getter
    private Boolean dairyAllergies;


}
