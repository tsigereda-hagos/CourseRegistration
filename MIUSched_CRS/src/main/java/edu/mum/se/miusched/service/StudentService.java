package edu.mum.se.miusched.service;

import java.util.List;
import edu.mum.se.miusched.domain.Student;
import edu.mum.se.miusched.service.exception.NotFoundException;

public interface StudentService {
	
	void addStudent(Student student);
	Student getStudent(Integer id) throws NotFoundException;
	List<Student> getAllStudents();
	void deleteStudent(Integer studentId);
	void updateStudent(Student student);
	

}
