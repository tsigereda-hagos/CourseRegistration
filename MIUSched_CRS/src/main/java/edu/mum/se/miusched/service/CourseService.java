package edu.mum.se.miusched.service;

import java.util.List;

import edu.mum.se.miusched.domain.Course;
import edu.mum.se.miusched.service.exception.NotFoundException;

public interface CourseService {
	void addCourse(Course course);
	Course getCourse(Integer id) throws NotFoundException;
	List<Course> getAllCourses();
	void deleteCourse(String courseId) throws NotFoundException;
	void editCourse(Course course);

}
