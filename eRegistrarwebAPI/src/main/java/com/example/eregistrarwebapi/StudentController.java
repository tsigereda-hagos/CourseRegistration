package com.example.eregistrarwebapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eregistrar/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> listAllStudents() {
        return studentService.listAllStudents();
    }

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
