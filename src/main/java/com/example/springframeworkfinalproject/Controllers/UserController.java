package com.example.springframeworkfinalproject.Controllers;


import com.example.springframeworkfinalproject.Data.ParseJSON;
import com.example.springframeworkfinalproject.Model.Answer;
import com.example.springframeworkfinalproject.Model.Question;
import com.example.springframeworkfinalproject.Model.Test;
import com.example.springframeworkfinalproject.Model.User;
import com.example.springframeworkfinalproject.RepositoryInterfaces.QuestionsRepository;
import com.example.springframeworkfinalproject.RepositoryInterfaces.TestRepository;
import com.example.springframeworkfinalproject.RepositoryInterfaces.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/")
public class UserController{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    @GetMapping(path = "/")
    public String home(Model model){
        model.addAttribute("user", new User());
        // Parse JSON file into Java object
        ParseJSON parseJSON = new ParseJSON("questions.json");
        ArrayList<Question> questions = parseJSON.getQuestions();

        // delete old questions in the table
        questionsRepository.deleteAll();

        // Save questions to question table in the database
        questionsRepository.saveAll(questions);
        return "home";
    }


    @PostMapping(path = "/question")
    public String loginAndSeedQuestions(@Valid User user,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "home";
        }
        Optional<User> tester = userRepository.findById(user.getUser_id());

        Answer answer = new Answer();

        if(tester.isPresent()){
            User u = tester.get();
            model.addAttribute("user", u);
            answer.setUser_id(u.getUser_id());
        }
        else {
            userRepository.save(user);
            model.addAttribute("user", user);
            answer.setUser_id(user.getUser_id());
        }
        Iterable<Question> questions = questionsRepository.findAll();
        model.addAttribute("questions",questions);

        model.addAttribute("answer", answer);
        return "question";
    }


}
