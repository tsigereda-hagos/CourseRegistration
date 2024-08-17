package edu.mum.se.miusched.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.se.miusched.domain.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	Optional<User> findUserByUsername(String username);// select query to DB
}
