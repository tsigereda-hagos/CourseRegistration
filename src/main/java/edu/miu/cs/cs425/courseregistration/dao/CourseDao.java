package edu.miu.cs.cs425.courseregistration.dao;

import java.util.List;

import edu.miu.cs.cs425.courseregistration.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

	List<Course> findAllByOrderByNameAsc();
}
