package com.demo.twitter.model;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tweets")
public class Tweet {

    private Logger logger = LoggerFactory.getLogger(Tweet.class);
    @Id
    private String id;

    private String content;

    private int numberOfRetweets;

    private Instant timestamp;

    private TweetMetadata metadata;

    public Tweet(String content, int numberOfRetweets, TweetMetadata metadata) {
        super();
        this.content = content;
        this.numberOfRetweets = numberOfRetweets;
        this.timestamp = Instant.now();
        this.metadata = metadata;
    }

    public String getId() {
        return id;
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

    public TweetMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(TweetMetadata metadata) {
        this.metadata = metadata;
    }

    /*@Override
    public String toString() {
        return "Tweet{" +
                "Id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", numberOfRetweets=" + numberOfRetweets +
                ", timestamp=" + timestamp +
                ", metadata=" + metadata.toString() +
                '}';
    }*/

    static class TweetMetadata {

        private String authorId;

        private List<String> hashTags;

        @JsonCreator
        public TweetMetadata(String authorId, List<String> hashTags) {

            this.hashTags = hashTags;
            this.authorId = authorId;
        }

        public String getAuthorId() {
            return authorId;
        }

        public List<String> getHashTags() {
            return hashTags;
        }

        /*@Override
        public String toString() {
            return "TweetMetadata{" +
                    "authorId='" + authorId + '\'' +
                    ", hashTags=" + hashTags +
                    '}';
        }*/
    }
}
