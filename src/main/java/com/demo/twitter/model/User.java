package com.demo.twitter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    public User(String id, String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }
}