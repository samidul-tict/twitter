package com.demo.twitter.controller;

import com.demo.twitter.model.User;
import com.demo.twitter.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepo;

	UserController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/users")
	List<User> getAllUsers() {

		logger.info("Getting all users...");
		return userRepo.findAll();
	}

	@PostMapping("/createuser")
	public void CreateUser(@RequestBody User newUser) {

		logger.info("Creating new user..." + newUser.toString());
		userRepo.save(newUser);
	}

	@GetMapping("/getuser")
	public User GetUserFromParam(@RequestParam(value = "id") String id) {
		return userRepo.findUserById(id);
				//.orElseThrow(() -> new UserNotFoundException(id));
	}

	@GetMapping("/getuser/{id}")
	public User GetUserFromPathVar(@PathVariable String id) {
		return userRepo.findUserById(id);
				//.orElseThrow(() -> new UserNotFoundException(id));
	}

	@PutMapping("/updateuser/{id}")
	public User UpdateUser(@RequestBody User updatedUser, @PathVariable String id) {
		return userRepo.findById(id)
				.map(user -> {
					user.setName(updatedUser.getName());
					user.setEmail(updatedUser.getEmail());
					return userRepo.save(user);
				})
				.orElseGet(() -> {
					return userRepo.save(updatedUser);
				});
	}

	@DeleteMapping("/deleteuser/{id}")
	public void DeleteUser(@PathVariable String id) {
		userRepo.deleteById(id);
	}
}
