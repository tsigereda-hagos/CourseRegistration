package edu.mum.se.miusched.service.Impl;

import edu.mum.se.miusched.service.StudentLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.se.miusched.dao.StudentLessonDao;
import edu.mum.se.miusched.domain.Lesson;
import edu.mum.se.miusched.domain.Student;
import edu.mum.se.miusched.domain.StudentLesson;

@Service
public class StudentLessonServiceImpl implements StudentLessonService {

	@Autowired
	private StudentLessonDao studentLessonDao;
	
	@Override
	public void createStudentLesson(Lesson lesson, Student student) {
		StudentLesson studentLesson = new StudentLesson();
		studentLesson.setLesson(lesson);
		studentLesson.setStudent(student);
		studentLessonDao.save(studentLesson);
	}

}
