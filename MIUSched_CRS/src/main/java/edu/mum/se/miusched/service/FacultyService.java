package edu.mum.se.miusched.service;

import java.util.List;

import edu.mum.se.miusched.domain.Faculty;

public interface FacultyService {
	void addFaculty(Faculty faculty);
	Faculty getFaculty(Integer facultyId);
	List<Faculty> getAllFaculties();
	void deleteFaculty(Integer facultyId);
	void editFaculty(Faculty faculty);
	
}
