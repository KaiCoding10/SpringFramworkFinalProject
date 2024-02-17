package com.example.springframeworkfinalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Size(min = 1,message = " First name is required!" )
    protected String firstName;

    @Column
    @NotNull
    @Size(min = 1,message  = "Last name is required!" )
    protected String lastName;

}
