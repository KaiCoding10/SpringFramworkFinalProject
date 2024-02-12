package com.example.springframeworkfinalproject.Controllers;


import com.example.springframeworkfinalproject.Model.User;
import com.example.springframeworkfinalproject.RepositoryInterfaces.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
//@CrossOrigin("*")
//@RequestMapping("/")
public class UserController{
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private TestRepository testRepository;

    //@Autowired
    //private QuestionsRepository questionsRepository;

    @GetMapping(path = "/")
    public String home(Model model){
        model.addAttribute("user", new User());
        return "home";
    }


    @PostMapping(path = "/user")
    public String loginAndSeedQuestions(@Valid User user,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "errorPage";
        }
        Optional<User> tester = userRepository.findById(user.getUser_id());

        if(tester.isPresent()){
            User u = tester.get();
            model.addAttribute("user", u);
        }
        else {
            userRepository.save(user);
            model.addAttribute("user", user);
        }

        return "userInfo";
    }


}
