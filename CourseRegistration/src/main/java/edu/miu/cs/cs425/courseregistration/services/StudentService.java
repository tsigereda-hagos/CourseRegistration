package edu.miu.cs.cs425.courseregistration.services;

import edu.miu.cs.cs425.courseregistration.domain.Student;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;

public interface StudentService {

    Student getStudent(Integer id) throws NotFoundException;
}
