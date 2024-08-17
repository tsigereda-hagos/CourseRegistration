package edu.miu.cs.cs425.courseregistration.dao;

import edu.miu.cs.cs425.courseregistration.domain.StudentLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLessonDao extends JpaRepository<StudentLesson, Integer> {

}
