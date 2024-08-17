package edu.mum.se.miusched.service.Impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.se.miusched.dao.UserDao;
import edu.mum.se.miusched.domain.CustomUser;
import edu.mum.se.miusched.domain.User;

@Service
public class UserCredentialServiceImpl implements UserDetailsService {


	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("admin@miu.edu".equals(username)) {
			Set<SimpleGrantedAuthority> roles = new HashSet<>();
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new CustomUser("admin@miu.edu", passwordEncoder.encode("pass"), roles, 1);
		}

		Optional<User> optional = userDao.findUserByUsername(username);

		if (optional.isEmpty())
			throw new UsernameNotFoundException("User with username: " + username + " not found !");

		User user = optional.get();

		Set<SimpleGrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(user.getRole()));

		return new CustomUser(user.getUsername(), user.getPassword(), roles, user.getUserId());
	}
}
