package edu.miu.cs.cs425.courseregistration.domain;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty extends Project_CourseRegistration.Domain.Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer id;
    @OneToMany(mappedBy = "faculty")
    private List<Project_CourseRegistration.Domain.Lesson> lessons;

    public List<Project_CourseRegistration.Domain.Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Project_CourseRegistration.Domain.Lesson> lessons) {
        this.lessons = lessons;
    }
}
