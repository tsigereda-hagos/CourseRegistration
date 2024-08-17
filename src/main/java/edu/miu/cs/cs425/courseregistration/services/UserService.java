package edu.miu.cs.cs425.courseregistration.services;

public interface UserService {
    Integer createUser(String username, String role);

    void updateUser(Integer id, String email);
}
