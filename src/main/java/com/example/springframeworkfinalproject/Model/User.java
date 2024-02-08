package com.example.springframeworkfinalproject.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int ID;

    @Column
    protected String firstName;

    @Column
    protected String lastName;
    @Column
    protected int score;

}
