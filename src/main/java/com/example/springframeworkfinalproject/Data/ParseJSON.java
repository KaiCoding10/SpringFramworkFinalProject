package com.example.springframeworkfinalproject.Data;

import com.example.springframeworkfinalproject.Model.Question;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ParseJSON {
    private ArrayList<Question> questions;

    // instance method
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    // constructor
    public ParseJSON(String fileName) {
        this.questions = new ArrayList<>();

        try{
            // Create a Gson object
            Gson gson = new Gson();

            // Define the type of the list you want to parse
            Type listType = new TypeToken<List<Question>>() {}.getType();

            // Parse the JSON file using Gson
            this.questions = gson.fromJson(new FileReader(fileName), listType);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
