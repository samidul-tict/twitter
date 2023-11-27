package com.demo.twitter.controller;

import com.demo.twitter.model.User;
import com.demo.twitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
@RestController
public class UserController {

	@Autowired
	UserRepository userRepo;

	public static void main(String[] args) {

		SpringApplication.run(UserController.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/createuser")
	public void CreateUser(@RequestParam(value = "name") String name) {
		userRepo.save();
	}

	@GetMapping("/getuser")
	public String GetUser(@RequestParam(value = "name") String name) {
		return "cde";
	}

	@GetMapping("/users")
	List<User> all() {
		return repository.findAll();
	}

	@PutMapping("/updateuser")
	public String UpdateUser(@RequestParam(value = "name") String name) {
		return "efg";
	}

	@DeleteMapping("/deleteuser")
	public String DeleteUser(@RequestParam(value = "name") String name) {
		return "pqr";
	}
}
