package com.example.eregistrar;

import com.example.eregistrar.Student;
import com.example.eregistrar.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import student repository

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/register")
    public String registerStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        existingStudent.setStudentNumber(student.getStudentNumber());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setMiddleName(student.getMiddleName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setCgpa(student.getCgpa());
        existingStudent.setEnrollmentDate(student.getEnrollmentDate());
        existingStudent.setIsInternational(student.getIsInternational());
        studentRepository.save(existingStudent);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentRepository.delete(student);
        return "redirect:/eregistrar/students";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam String query, Model model) {
        List<Student> students = studentRepository.findByFirstNameContainingIgnoreCase(query);
        model.addAttribute("students", students);
        return "students";
    }
}
