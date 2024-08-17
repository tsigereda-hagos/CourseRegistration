package edu.miu.cs.cs425.courseregistration.dao;

import edu.miu.cs.cs425.courseregistration.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonDao extends JpaRepository<Lesson, Integer> {

    List<Lesson> findByFacultyId(Integer facultyId);

    List<Lesson> findByBlockId(Integer blockId);
}
