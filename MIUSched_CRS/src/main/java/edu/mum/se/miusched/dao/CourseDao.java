package edu.mum.se.miusched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.se.miusched.domain.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> { //entity type, primary key type, better than CRUD

	List<Course> findAllByOrderByNameAsc();
}
