package com.demo.twitter.repository;

import com.demo.twitter.model.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TweetRepository extends MongoRepository<Tweet, String> {

    List<Tweet> findTweetById(String authorId);

    List<Tweet> findAll();
}
