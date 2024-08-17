package edu.miu.cs.cs425.courseregistration.services;

import java.util.List;

import edu.miu.cs.cs425.courseregistration.domain.Course;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;


public interface CourseService {
	void addCourse(Course course);
	Course getCourse(Integer id) throws NotFoundException;
	List<Course> getAllCourses();
	void deleteCourse(String courseId) throws NotFoundException;
	void editCourse(Course course);

}
