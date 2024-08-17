package edu.mum.se.miusched.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.se.miusched.domain.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer>{

}
