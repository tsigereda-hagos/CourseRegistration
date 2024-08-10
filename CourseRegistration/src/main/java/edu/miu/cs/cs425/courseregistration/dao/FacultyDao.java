package edu.miu.cs.cs425.courseregistration.dao;

import edu.miu.cs.cs425.courseregistration.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface FacultyDao extends JpaRepository<Faculty, Integer> {

    }

