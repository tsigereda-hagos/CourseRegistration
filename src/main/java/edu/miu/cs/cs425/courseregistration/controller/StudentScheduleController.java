package edu.miu.cs.cs425.courseregistration.controller;

import edu.miu.cs.cs425.courseregistration.component.SessionManager;
import edu.miu.cs.cs425.courseregistration.domain.Lesson;
import edu.miu.cs.cs425.courseregistration.domain.StudentSchedule;
import edu.miu.cs.cs425.courseregistration.services.BlockService;
import edu.miu.cs.cs425.courseregistration.services.LessonService;
import edu.miu.cs.cs425.courseregistration.services.StudentScheduleService;
import edu.miu.cs.cs425.courseregistration.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/student")
public class StudentScheduleController {
    @Autowired
    private StudentScheduleService studentScheduleService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SessionManager session;

    @Autowired
    private BlockService blockService;

    @GetMapping("")
    public String showStudentSchedule(Model model) {
        //Get blocks after the entry based on track
        List<StudentSchedule> schedules = studentScheduleService.getSchedules();
        model.addAttribute("schedules", schedules);
        model.addAttribute("student", studentService.getStudent(session.getUser().getId()));

        return "schedule-student";
    }

    @GetMapping("/schedule/block/{blockId}")
    public String showStudentAddScheduleForm(Model model, @PathVariable("blockId") String blockId) {
        model.addAttribute("block", blockService.getBlock(Integer.parseInt(blockId)));
        model.addAttribute("newLesson", new Lesson());
        model.addAttribute("lessons", lessonService.getLessonsByBlockId(blockId));
        return "schedule-student-create";
    }

    @PostMapping("/schedule")
    public String createLesson(Lesson lesson) {
        studentScheduleService.assignToLesson(lesson);
        return "redirect:../student";
    }
}
