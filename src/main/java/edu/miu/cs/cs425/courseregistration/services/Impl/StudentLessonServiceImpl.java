package edu.miu.cs.cs425.courseregistration.services.Impl;

import edu.miu.cs.cs425.courseregistration.dao.StudentLessonDao;
import edu.miu.cs.cs425.courseregistration.domain.Lesson;
import edu.miu.cs.cs425.courseregistration.domain.Student;
import edu.miu.cs.cs425.courseregistration.domain.StudentLesson;
import edu.miu.cs.cs425.courseregistration.services.StudentLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
