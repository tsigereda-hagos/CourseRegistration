package edu.miu.cs.cs425.courseregistration.services;

import edu.miu.cs.cs425.courseregistration.domain.Lesson;
import edu.miu.cs.cs425.courseregistration.domain.Student;

public interface StudentLessonService {
   void createStudentLesson(Lesson lesson, Student student);
}
