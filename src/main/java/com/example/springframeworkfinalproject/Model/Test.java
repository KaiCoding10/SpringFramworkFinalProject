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
    protected int right_answer;

    @Column
    protected int wrong_answer;

    @Column
    protected int total_question;

    @Column
    protected int score;

}
