package edu.miu.cs.cs425.courseregistration.domain;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Course {

    @Column
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;


    public String getName() {
        return name;
    }
}
