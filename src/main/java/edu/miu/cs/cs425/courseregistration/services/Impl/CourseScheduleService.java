package edu.miu.cs.cs425.courseregistration.services.Impl;

import edu.miu.cs.cs425.courseregistration.dao.CourseScheduleRepository;
import edu.miu.cs.cs425.courseregistration.domain.CourseSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseScheduleService {
    @Autowired
    CourseScheduleRepository courseScheduleRepository;

    public Iterable<CourseSchedule> getCourseSchedules(){
        return courseScheduleRepository.findAll();
    }

    public CourseSchedule getCourseSchedule(long id){
        return courseScheduleRepository.findCourseScheduleById(id);
    }

    public ResponseEntity Create(CourseSchedule course){
        CourseSchedule obj = CourseSchedule.createCourseSchedule(course.getBlock(), course.getCourse());
        try {
            courseScheduleRepository.save(obj);
        }
        catch (Exception e)
        {

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(obj.toString());
    }

    public ResponseEntity Update(CourseSchedule course){
        try {
            courseScheduleRepository.save(course);
        }
        catch (Exception e)
        {

        }
        return ResponseEntity.status(HttpStatus.CREATED).body(course.toString());
    }

    public void delete (Long courseId){
        try {
            CourseSchedule courseSchedule = getCourseSchedule(courseId);
            courseScheduleRepository.delete(courseSchedule);
        }catch(Exception ex){
            throw  ex;
        }
    }




}
