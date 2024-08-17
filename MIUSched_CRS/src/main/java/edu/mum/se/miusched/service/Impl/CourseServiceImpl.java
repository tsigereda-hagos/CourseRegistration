package edu.mum.se.miusched.service.Impl;

import java.util.List;
import java.util.Optional;

import edu.mum.se.miusched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.se.miusched.dao.CourseDao;
import edu.mum.se.miusched.domain.Course;
import edu.mum.se.miusched.service.exception.NotFoundException;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public void addCourse(Course course) {
		courseDao.save(course); // save: update old, insert new if id is empty, save() ni Id tai esehiig n dotroo shalgana
	}

	@Override
	public Course getCourse(Integer id) throws NotFoundException {
		Optional<Course> course = courseDao.findById(id);
		if (course.isEmpty()) {
			throw new NotFoundException("No course with id " + id + " found.");
		}
		return course.get();
	}

	@Override
	public List<Course> getAllCourses() {
		return courseDao.findAllByOrderByNameAsc();
	}

	@Override
	public void deleteCourse(String courseId) throws NotFoundException {
		try {
			Integer id = Integer.parseInt(courseId);
			courseDao.deleteById(id);
		} catch(NumberFormatException ex) {
			throw new NotFoundException("No course with id " + courseId + " found.");
		}
	}

	@Override
	public void editCourse(Course course) { // edit 
		addCourse(course);
	}

}
