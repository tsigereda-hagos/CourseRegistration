package edu.miu.cs.cs425.courseregistration.services.Impl;

import edu.miu.cs.cs425.courseregistration.dao.FacultyDao;
import edu.miu.cs.cs425.courseregistration.domain.Faculty;
import edu.miu.cs.cs425.courseregistration.services.FacultyService;
import edu.miu.cs.cs425.courseregistration.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private static final String FACULTY_ROLE = "ROLE_FACULTY";

    @Autowired
    private FacultyDao facultyDao;

    @Autowired
    private UserService userService;

    @Override
    public void addFaculty(Faculty faculty) {
        Integer studentId = userService.createUser(faculty.getEmail(), FACULTY_ROLE);
        faculty.setId(studentId);
        facultyDao.save(faculty);
    }

    @Override
    public Faculty getFaculty(Integer id) {
        Optional<Faculty> faculty = facultyDao.findById(id);

        if(faculty.isEmpty())
            throw new NotFoundException("No faculty with id " + id + " found.");

        return faculty.get();
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyDao.findAll();
    }

    @Override
    public void deleteFaculty(Integer facultyId) {
        facultyDao.deleteById(facultyId);
    }

    @Override
    public void editFaculty(Faculty faculty) {
        userService.updateUser(faculty.getId(), faculty.getEmail());
        facultyDao.save(faculty);
    }

}