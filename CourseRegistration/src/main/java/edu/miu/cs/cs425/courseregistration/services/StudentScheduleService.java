package edu.miu.cs.cs425.courseregistration.services;

import edu.miu.cs.cs425.courseregistration.domain.Lesson;
import edu.miu.cs.cs425.courseregistration.domain.StudentSchedule;

import java.util.List;

public interface StudentScheduleService {
    List<StudentSchedule> getSchedules();

    void assignToLesson(Lesson lesson);
}
