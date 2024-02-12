package com.example.springframeworkfinalproject.RepositoryInterfaces;

import com.example.springframeworkfinalproject.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
