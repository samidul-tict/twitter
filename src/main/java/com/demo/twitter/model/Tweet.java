package com.demo.twitter.model;

import com.mongodb.BSONTimestampCodec;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class tweet {

    @Id
    private String tweetId;

    private String tweetContent;

    private int numberOfRetweets;

    private BSONTimestampCodec timestamp;

    private metadata
}
