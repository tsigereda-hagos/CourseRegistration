package edu.miu.cs.cs425.courseregistration.dao;

import edu.miu.cs.cs425.courseregistration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
}
