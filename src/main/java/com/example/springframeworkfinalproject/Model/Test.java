package com.example.springframeworkfinalproject.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int user_id;

    @Column
    protected int right_answer = 0;

    @Column
    protected int wrong_answer = 0;

    @Column
    protected int total_question = 0;

    @Column
    protected int score = 0;

    public void addRightAns(){
        this.right_answer += 1;
    }

    public void addWrongAns(){
        this.wrong_answer += 1;
    }

    public void addTotalQues(){
        this.total_question += 1;
    }

    public void addScore(){
        this.score += 10;
    }

}
