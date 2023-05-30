package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;


	@Autowired
	private PasswordEncoder passwordEncoder;

	public void initRoleAndUser() {


		User adminUser = new User();
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		adminUser.setEmail("admin@gmail.com");
		Set<String> adminRoles = new HashSet<>();
		adminRoles.add("admin");
		adminUser.setRole(adminRoles);
		userRepo.save(adminUser);
	}

	public User registerNewUser(User user) {
		//Role role = roleRepo.findById("User").get();
		Set<String> userRoles = new HashSet<>();
		userRoles.add("user");
		user.setRole(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));

		return userRepo.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public Optional<User> getUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
