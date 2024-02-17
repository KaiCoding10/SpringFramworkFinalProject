package com.example.springframeworkfinalproject.Controllers;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/")
public class TestController {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private UserRepository userRepository;
    @PostMapping(path = "/test")
    public String displayResults(@Valid Answer answer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "question";
        }
        Test test = new Test();

        Iterable<Question> questions = questionsRepository.findAll();
        int x = 0;
        for ( Question q : questions){
            if(q.getCorrect_answer().equalsIgnoreCase(answer.getAns().get(x))){
                test.addRightAns();
                test.addScore();
            }
            else{
                test.addWrongAns();
            }
            test.addTotalQues();
            x += 1;
        }

        Optional<Test> oldTest = testRepository.findById(answer.getUser_id());
        int highestScore;
        if(oldTest.isPresent()){
            Test oldT = oldTest.get();
            highestScore = oldT.getScore();
            if(test.getScore() > oldT.getScore()){
                // update the existing test
                oldT.setScore(test.getScore());
                oldT.setRight_answer(test.getRight_answer());
                oldT.setWrong_answer(test.getWrong_answer());

                testRepository.save(oldT);
                highestScore = test.getScore();
            }
        }
        else{
            highestScore = test.getScore();
            testRepository.save(test);
        }

        model.addAttribute("highestScore", highestScore);
        model.addAttribute("test", test);

        Optional<User> u = userRepository.findById(answer.getUser_id());
        User user = new User();
        if(u.isPresent()){
            user = u.get();
        }
        model.addAttribute("user", user);

        return "result";
    }

}
