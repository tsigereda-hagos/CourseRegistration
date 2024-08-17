package edu.mum.se.mumsched.service;

import edu.miu.cs.cs425.courseregistration.domain.Course;
import edu.miu.cs.cs425.courseregistration.domain.FacultySchedule;

import java.util.List;


public interface FacultyScheduleService {

	List<FacultySchedule> getSchedules();

	void addLessonToFaculty(String blockId, Course course);
}
