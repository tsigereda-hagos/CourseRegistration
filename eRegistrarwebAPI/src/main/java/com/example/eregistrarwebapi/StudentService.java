package com.example.eregistrarwebapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudentOpt = studentRepository.findById(id);

        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();
            existingStudent.setStudentNumber(updatedStudent.getStudentNumber());
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setMiddleName(updatedStudent.getMiddleName());
            existingStudent.setLastName(updatedStudent.getLastName());
            existingStudent.setCgpa(updatedStudent.getCgpa());
            existingStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());
            existingStudent.setIsInternational(updatedStudent.getIsInternational());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
