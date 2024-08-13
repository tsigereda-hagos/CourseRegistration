package edu.miu.cs.cs425.courseregistration.services.Impl;


import edu.miu.cs.cs425.courseregistration.dao.LessonDao;
import edu.miu.cs.cs425.courseregistration.domain.Block;
import edu.miu.cs.cs425.courseregistration.domain.Course;
import edu.miu.cs.cs425.courseregistration.domain.Faculty;
import edu.miu.cs.cs425.courseregistration.domain.Lesson;
import edu.miu.cs.cs425.courseregistration.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;

    @Override
    public List<Project_CourseRegistration.Domain.Lesson> getLessonsByBlockId(String blockId) {
        return lessonDao.findByBlockId(Integer.parseInt(blockId));
    }

    @Override
    public List<Lesson> getLessonByFacultyId(Integer facultyId) {
        return lessonDao.findByFacultyId(facultyId);
    }

    @Override
    public void createLesson(Block block, Course course, Faculty faculty) {
        Lesson lesson = new Lesson();
        lesson.setBlock(block);
        lesson.setCourse(course);
        lesson.setFaculty(faculty);

        lessonDao.save(lesson);
    }

    @Override
    public Lesson getLessonById(Integer lessonId) {
        return lessonDao.findById(lessonId).get();
    }

}
