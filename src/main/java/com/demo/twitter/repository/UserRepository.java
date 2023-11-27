package com.demo.twitter.repository;

import java.util.List;
import com.demo.twitter.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserById(String id);

    List<User> findAll();
}
