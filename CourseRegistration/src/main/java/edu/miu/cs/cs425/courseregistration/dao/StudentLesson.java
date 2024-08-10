package edu.miu.cs.cs425.courseregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLesson extends JpaRepository<StudentLesson, Integer> {

}
