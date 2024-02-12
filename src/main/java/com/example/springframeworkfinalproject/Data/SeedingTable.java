package com.example.springframeworkfinalproject.Data;

import com.example.springframeworkfinalproject.Model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeedingTable {

    private ArrayList<Question> questions;
    public SeedingTable(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void seedQuestions(String fileName){
        if(!isTableEmpty()){
            //TODO display the error page
        }
        // instantiate the ParseJSON object to parse the json file into Java objects
        ParseJSON parseJSON = new ParseJSON(fileName);

        ArrayList<Question> questions = parseJSON.getQuestions();

        for (Question c: questions){
            //TODO add each question into the table
        }

    }
    public boolean isTableEmpty() {

        return true;
    }
}
