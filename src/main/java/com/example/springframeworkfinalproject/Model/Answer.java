package com.example.springframeworkfinalproject.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Answer {
    protected int user_id;

    @NotNull
    @Size(min = 1,message = " Answer is required!" )
    protected ArrayList<String> ans;

}
