package edu.miu.cs.cs425.courseregistration.services;

import edu.miu.cs.cs425.courseregistration.domain.Faculty;

import java.util.List;

public interface FacultyService {
    void addFaculty(Faculty faculty);
    Faculty getFaculty(Integer facultyId);
    List<Faculty> getAllFaculties();
    void deleteFaculty(Integer facultyId);
    void editFaculty(Faculty faculty);

}
