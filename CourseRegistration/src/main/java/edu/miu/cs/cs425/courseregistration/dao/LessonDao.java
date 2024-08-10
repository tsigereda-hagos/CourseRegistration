package edu.miu.cs.cs425.courseregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonDao extends JpaRepository<Project_CourseRegistration.Domain.Lesson, Integer> {

    List<Project_CourseRegistration.Domain.Lesson> findByFacultyId(Integer facultyId);

    List<Project_CourseRegistration.Domain.Lesson> findByBlockId(Integer blockId);
}
