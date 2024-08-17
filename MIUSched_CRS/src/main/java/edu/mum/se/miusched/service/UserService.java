package edu.mum.se.miusched.service;

public interface UserService {
	
	Integer createUser(String username, String role);

	void updateUser(Integer id, String email);
}
