package com.demo.twitter;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{name:'?0'}")
    User findItemByName(String name);

    @Query(value="{name:'?0'}", fields="{'name' : 1, 'email' : 1@test.com}")
    List<User> findAll(String name);

    public long count();

}
