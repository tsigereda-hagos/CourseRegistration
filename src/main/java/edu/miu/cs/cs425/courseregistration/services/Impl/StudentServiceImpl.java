package edu.miu.cs.cs425.courseregistration.services.Impl;

import java.util.List;
import java.util.Optional;

import edu.miu.cs.cs425.courseregistration.dao.StudentDao;
import edu.miu.cs.cs425.courseregistration.domain.Entry;
import edu.miu.cs.cs425.courseregistration.domain.Student;
import edu.miu.cs.cs425.courseregistration.services.EntryService;
import edu.miu.cs.cs425.courseregistration.services.StudentService;
import edu.miu.cs.cs425.courseregistration.services.UserService;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {
	
	private static final String STUDENT_ROLE = "ROLE_STUDENT";

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EntryService entryService;

	@Override
	public void addStudent(Student student) {
		Integer studentId = userService.createUser(student.getEmail(), STUDENT_ROLE);
		Entry entry = entryService.getEntry(student.getEntry().getId());
		
		student.setId(studentId);
		student.setEntry(entry);

		studentDao.save(student);
	}

	@Override
	public Student getStudent(Integer id) throws NotFoundException {
		Optional<Student> student = studentDao.findById(id);
		
		if(student.isEmpty())
			throw new NotFoundException("No student with id " + id + " found.");
		
		return student.get();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public void deleteStudent(Integer studentId) {
		studentDao.deleteById(studentId);
		
	}

	@Override
	public void updateStudent(Student student) {
		userService.updateUser(student.getId(), student.getEmail());
		studentDao.save(student);
	}

}
