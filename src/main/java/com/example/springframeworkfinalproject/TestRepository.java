package com.example.springframeworkfinalproject;
import com.example.springframeworkfinalproject.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface TestRepository extends MongoRepository<User, String>{

}
