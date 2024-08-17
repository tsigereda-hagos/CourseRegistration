package edu.miu.cs.cs425.courseregistration.controller;
import java.util.List;

import edu.miu.cs.cs425.courseregistration.domain.Student;
import edu.miu.cs.cs425.courseregistration.domain.Track;
import edu.miu.cs.cs425.courseregistration.services.EntryService;
import edu.miu.cs.cs425.courseregistration.services.StudentService;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EntryService entryService;
	
	@GetMapping("")
	public String showStudentPage(Model model) {
		List<Student> list = studentService.getAllStudents();
		model.addAttribute("students", list);
		return "student-list";
	}
	
	@GetMapping("/add")
	public String showNewStudentForm(Model model) {
		//Might be create entry here...
		model.addAttribute("entries", entryService.getAllEntries());
		model.addAttribute("tracks", Track.values());
		
		model.addAttribute("newStudent", new Student());
		return "student-create";
	}
	
	@PostMapping("/add")
	public String addNewStudent(Student student) {
		studentService.addStudent(student);
		return "redirect:../student";
	}
	
	@DeleteMapping("/delete/{studentId}")
	@ResponseBody
	public String deleteStudent(@PathVariable("studentId") String id) {
		studentService.deleteStudent(Integer.parseInt(id));
		return "redirect:../../student";
	}
	
	@GetMapping("/edit/{studentId}")
	public String showUpdateStudent(@PathVariable("studentId") String id, Model model) throws NotFoundException {
		Student student = studentService.getStudent(Integer.parseInt(id));
		model.addAttribute("student", student);
		return "student-edit";
	}
	
	@PostMapping("/edit")
	public String updateStudent(Model model, Student student) {
		studentService.updateStudent(student);
		return "redirect:../student";
	}
}
