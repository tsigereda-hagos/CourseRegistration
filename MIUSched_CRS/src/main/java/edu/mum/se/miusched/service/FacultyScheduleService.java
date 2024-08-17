package edu.mum.se.miusched.service;

import java.util.List;

import edu.mum.se.miusched.domain.Course;
import edu.mum.se.miusched.domain.FacultySchedule;

public interface FacultyScheduleService {

	List<FacultySchedule> getSchedules();

	void addLessonToFaculty(String blockId, Course course);
}
