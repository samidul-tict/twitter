package com.demo.twitter.model;

import com.demo.twitter.controller.TweetController;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TweetMetadata {

    private Logger logger = LoggerFactory.getLogger(TweetMetadata.class);
    private String authorId;

    private List<String> hashTags;

    public TweetMetadata(String authorId, List<String> hastTags) {

        logger.info("authorId: " + authorId + ", hastTags: " + hastTags.toString());
        this.hashTags = hastTags;
        this.authorId = authorId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<String> hashTags) {
        this.hashTags = hashTags;
    }

    @Override
    public String toString() {
        return "TweetMetadata{" +
                "authorId='" + authorId + '\'' +
                ", hashTags=" + hashTags +
                '}';
    }
}