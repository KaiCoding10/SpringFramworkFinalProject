package com.example.springframeworkfinalproject.Model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int user_id;

    @Column
    protected String firstName;

    @Column
    protected String lastName;

}
