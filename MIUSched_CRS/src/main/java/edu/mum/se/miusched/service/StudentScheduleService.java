package edu.mum.se.miusched.service;

import java.util.List;

import edu.mum.se.miusched.domain.Lesson;
import edu.mum.se.miusched.domain.StudentSchedule;

public interface StudentScheduleService {

	List<StudentSchedule> getSchedules();

	void assignToLesson(Lesson lesson);

}
