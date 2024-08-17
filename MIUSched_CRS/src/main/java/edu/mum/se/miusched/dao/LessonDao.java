package edu.mum.se.miusched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.se.miusched.domain.Lesson;

@Repository
public interface LessonDao extends JpaRepository<Lesson, Integer> {
	
	List<Lesson> findByFacultyId(Integer facultyId);

	List<Lesson> findByBlockId(Integer blockId);
}
