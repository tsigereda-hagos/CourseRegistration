package edu.mum.se.miusched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.se.miusched.domain.StudentLesson;

@Repository
public interface StudentLessonDao extends JpaRepository<StudentLesson, Integer> {

}
