package edu.miu.cs.cs425.courseregistration.services.Impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.cs425.courseregistration.domain.Course;
import edu.miu.cs.cs425.courseregistration.services.CourseService;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;


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
		return Course.findAllByOrderByNameAsc();
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
