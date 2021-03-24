package io.fortylines.hrcrm.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @Email
    @Size(min = 5, max = 30)
    private String email;

    @NotNull
    @Size(min = 8, max = 25)
    private String phoneNumber;

    @Size(min = 2, max = 30)
    private String discord;

    @Size(min = 2, max = 30)
    private String department;

    @Size(min = 1, max = 10)
    private String yearsOfExperience;

    @Size(min = 2, max = 30)
    private String degree;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;
}
