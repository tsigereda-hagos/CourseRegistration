package edu.mum.se.miusched;

import edu.mum.se.miusched.dao.UserDao;
import edu.mum.se.miusched.service.StudentService;
import edu.mum.se.miusched.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiuSchedApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	@Autowired
	private UserDao userDao;

	@Autowired
	StudentService studentService;


	public static void main(String[] args) {
		SpringApplication.run(MiuSchedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");






	}
}
