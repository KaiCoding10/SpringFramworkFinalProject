package com.example.springframeworkfinalproject.Model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int question_num;

    @Column
    protected String question;

    @Column
    protected String answer_1;

    @Column
    protected String answer_2;

    @Column
    protected String answer_3;

    @Column
    protected String correct_answer;

}
