package edu.miu.cs.cs425.courseregistration.services;

import edu.miu.cs.cs425.courseregistration.domain.Block;
import edu.miu.cs.cs425.courseregistration.domain.Course;
import edu.miu.cs.cs425.courseregistration.domain.Faculty;
import edu.miu.cs.cs425.courseregistration.domain.Lesson;
import java.util.List;

public interface LessonService {

    List<Lesson> getLessonsByBlockId(String blockId);



    List<Lesson> getLessonByFacultyId(Integer facultyId);

    void createLesson(Block block, Course course, Faculty faculty);

    Lesson getLessonById(Integer lessonId);

}