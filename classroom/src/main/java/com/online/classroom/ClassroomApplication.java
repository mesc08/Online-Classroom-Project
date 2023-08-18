package com.online.classroom;

import com.online.classroom.model.Role;
import com.online.classroom.model.User;
import com.online.classroom.model.UserRole;
import com.online.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
//public class ClassroomApplication implements CommandLineRunner {
public class ClassroomApplication {
	//	@Autowired
//	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ClassroomApplication.class, args);
	}
}
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("starting code");
//		User user = new User();
//		user.setFirstName("Durgesh");
//		user.setLastName("tiwari");
//		user.setUserName("mcfu");
//		user.setPassword("hellofu");
//		user.setEmail("abc@gmail.com");
//		user.setProfile("defautl.png");
//
//		Role role1 = new Role();
//		role1.setId(11L);
//		role1.setRoleName("admin");
//		UserRole uRole1 = new UserRole();
//		uRole1.setRole(role1);
//		uRole1.setUser(user);
//		Set<UserRole> userRoleSet = new HashSet<>();
//		userRoleSet.add(uRole1);
//
//		User  user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUserName());
//	}
//}
