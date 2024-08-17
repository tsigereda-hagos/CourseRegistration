package edu.miu.cs.cs425.courseregistration.dao;

import edu.miu.cs.cs425.courseregistration.domain.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Long> {
    CourseSchedule findCourseScheduleById(long id);

    @Query("SELECT CASE WHEN COUNT(c.id) > 0 THEN true ELSE false END  " +
            "FROM CourseSchedule c WHERE c.course.id = ?1")
    boolean CheckCourseInUsed (long id);
}
