package edu.mum.se.miusched.service.Impl;

import edu.mum.se.miusched.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.se.miusched.component.SessionManager;
import edu.mum.se.miusched.dao.UserDao;
import edu.mum.se.miusched.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	private static final CharSequence DEFAULT_PASSWORD = "pass";

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionManager session;
	
	@Override
	public Integer createUser(String username, String role) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
		user.setRole(role);
		user.setEnabled(true);
		
		return userDao.save(user).getUserId();
	}

	@Override
	public void updateUser(Integer userId, String email) {
		User user = userDao.findById(userId).get();
		user.setUsername(email);
		userDao.save(user);
	}
}
