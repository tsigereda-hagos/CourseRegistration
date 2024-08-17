package edu.mum.se.miusched.service;

import java.util.List;

import edu.mum.se.miusched.domain.Block;
import edu.mum.se.miusched.domain.Course;
import edu.mum.se.miusched.domain.Faculty;
import edu.mum.se.miusched.domain.Lesson;

public interface LessonService {

	List<Lesson> getLessonsByBlockId(String blockId);

	List<Lesson> getLessonByFacultyId(Integer facultyId);

	void createLesson(Block block, Course course, Faculty faculty);

	Lesson getLessonById(Integer lessonId);

}
