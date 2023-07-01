package com.example.spring_training.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private double course_to_rubble;

    public Currency() {
    }

    public Currency(String name, double course_to_rubble) {
        this.name = name;
        this.course_to_rubble = course_to_rubble;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCourse_to_rubble() {
        return course_to_rubble;
    }

    public void setCourse_to_rubble(double course_to_rubble) {
        this.course_to_rubble = course_to_rubble;
    }
}
