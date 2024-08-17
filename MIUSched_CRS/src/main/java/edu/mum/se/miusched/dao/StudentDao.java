package edu.mum.se.miusched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.mum.se.miusched.domain.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}
