package com.demo.twitter.model;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Tweet")
public class Tweet {

    private Logger logger = LoggerFactory.getLogger(Tweet.class);
    @Id
    private String Id;

    private String content;

    private int numberOfRetweets;

    private Instant timestamp;

    private TweetMetadata metadata;

    public Tweet(String content, int numberOfRetweets, StringBuffer metadata) {
        this.content = content;
        this.numberOfRetweets = numberOfRetweets;
        this.timestamp = Instant.now();
        logger.info("metadata: " + metadata);
        logger.info("metadata class: " + metadata.getClass());
        //this.metadata = metadata;
    }

    public String getId() {
        return Id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumberOfRetweets() {
        return numberOfRetweets;
    }

    public void setNumberOfRetweets(int numberOfRetweets) {
        this.numberOfRetweets = numberOfRetweets;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    /*public TweetMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(TweetMetadata metadata) {
        this.metadata = metadata;
    }*/

    @Override
    public String toString() {
        return "Tweet{" +
                "Id='" + Id + '\'' +
                ", content='" + content + '\'' +
                ", numberOfRetweets=" + numberOfRetweets +
                ", timestamp=" + timestamp +
                //", metadata=" + metadata.toString() +
                '}';
    }
}
