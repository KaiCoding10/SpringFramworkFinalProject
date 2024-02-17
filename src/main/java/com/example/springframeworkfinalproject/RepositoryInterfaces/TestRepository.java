package com.example.springframeworkfinalproject.RepositoryInterfaces;
import com.example.springframeworkfinalproject.Model.Test;
import com.example.springframeworkfinalproject.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer> {

}
