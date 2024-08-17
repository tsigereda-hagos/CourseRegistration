package edu.miu.cs.cs425.courseregistration.services.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.miu.cs.cs425.courseregistration.component.SessionManager;
import edu.miu.cs.cs425.courseregistration.domain.*;
import edu.miu.cs.cs425.courseregistration.services.BlockService;
import edu.miu.cs.cs425.courseregistration.services.FacultyService;
import edu.miu.cs.cs425.courseregistration.services.LessonService;
import edu.mum.se.mumsched.service.FacultyScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacultyScheduleServiceImpl implements FacultyScheduleService {

	@Autowired
	private BlockService blockService;

	//@Autowired
	//private LessonDao lessonDao;
	

	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private SessionManager session;
	
	@Autowired
	private FacultyService facultyService;
	
	@Override
	public List<FacultySchedule> getSchedules() {
		List<Block> blocks = blockService.getAllBlocks();
		List<Lesson> lessons = lessonService.getLessonByFacultyId(session.getUser().getId());
		Collections.sort(lessons, (a, b) -> a.getBlock().getYear() * 100 + a.getBlock().getMonth() - b.getBlock().getYear() * 100 - b.getBlock().getMonth());
		
		List<FacultySchedule> schedules = new ArrayList<>(blocks.size());
		int i = 0; //lesson pointer
		for(Block block : blocks) {
			FacultySchedule sched = new FacultySchedule();
			sched.setBlock(block.clone());
			
			if(lessons != null && !lessons.isEmpty() && i < lessons.size()
					&& block.getYear() == lessons.get(i).getBlock().getYear() && block.getMonth() == lessons.get(i).getBlock().getMonth()) {
				sched.setCourse(lessons.get(i).getCourse().clone());
				sched.setLessonId(lessons.get(i).getId());
				i++;
			}
			schedules.add(sched);
		}
		return schedules;
	}

	@Override
	public void addLessonToFaculty(String blockId, Course course) {
		Block block = blockService.getBlock(Integer.parseInt(blockId));
		Faculty faculty = facultyService.getFaculty(session.getUser().getId());
		lessonService.createLesson(block, course, faculty);
	}
}
