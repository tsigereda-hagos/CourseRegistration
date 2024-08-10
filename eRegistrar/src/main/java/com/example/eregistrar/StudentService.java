package com.example.eregistrar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        existingStudent.setStudentNumber(student.getStudentNumber());
        ((Student) existingStudent).setFirstName(student.getFirstName());
        existingStudent.setMiddleName(student.getMiddleName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setCgpa(student.getCgpa());
        existingStudent.setEnrollmentDate(student.getEnrollmentDate());
        existingStudent.setIsInternational(student.getIsInternational());
        studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentRepository.delete(student);
    }

    public List<Student> searchStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstNameContainingIgnoreCase(firstName);
    }
}