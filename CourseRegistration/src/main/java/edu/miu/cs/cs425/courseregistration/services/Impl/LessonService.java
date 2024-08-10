package edu.miu.cs.cs425.courseregistration.services.Impl;

import edu.miu.cs.cs425.courseregistration.domain.Block;
import edu.miu.cs.cs425.courseregistration.domain.Course;
import edu.miu.cs.cs425.courseregistration.domain.Faculty;
import org.hibernate.mapping.List;

public interface LessonService {

    List<Project_CourseRegistration.Domain.Lesson> getLessonsByBlockId(String blockId);



    List<Project_CourseRegistration.Domain.Lesson> getLessonByFacultyId(Integer facultyId);

    void createLesson(Block block, Course course, Faculty faculty);

    Project_CourseRegistration.Domain.Lesson getLessonById(Integer lessonId);

}