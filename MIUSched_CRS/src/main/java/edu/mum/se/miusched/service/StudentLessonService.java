package edu.mum.se.miusched.service;

import edu.mum.se.miusched.domain.Lesson;
import edu.mum.se.miusched.domain.Student;

public interface StudentLessonService {

	void createStudentLesson(Lesson lesson, Student student);

}
