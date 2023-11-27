package com.demo.twitter.controller;

import com.demo.twitter.model.Tweet;
import com.demo.twitter.repository.TweetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {

    private Logger logger = LoggerFactory.getLogger(TweetController.class);

    @Autowired
    TweetRepository tweetRepo;

    TweetController(TweetRepository tweetRepo) {
        this.tweetRepo = tweetRepo;
    }

    @GetMapping("/gettweet/{authorid}")
    List<Tweet> getTweetByAuthor(@PathVariable String authorid) {

        logger.info("Getting all tweets by author...");
        return tweetRepo.findTweetById(authorid);
    }

    @PostMapping("/createtweet")
    public void CreateTweet(@RequestBody Tweet newTweet) {

        logger.info("Before creating new tweet..." + newTweet.toString());
        tweetRepo.save(newTweet);
        logger.info("After creating new tweet..." + newTweet.toString());
    }

    @DeleteMapping("/deletetweet/{tweetId}")
    public void DeleteTweet(@PathVariable String tweetId) {

        logger.info("Deleting tweet..." + tweetId);
        tweetRepo.deleteById(tweetId);
    }
}
