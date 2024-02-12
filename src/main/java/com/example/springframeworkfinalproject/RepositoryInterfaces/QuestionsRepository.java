package com.example.springframeworkfinalproject.RepositoryInterfaces;

import com.example.springframeworkfinalproject.Model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionsRepository extends CrudRepository<Question, Long> {
}
