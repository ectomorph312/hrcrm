package io.fortylines.hrcrm.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "degree")
    private String degree;

    @Column(name = "department")
    private String department;

    @Column(name = "discord")
    private String discord;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "years_of_experience")
    private String yearsOfExperience;

    @Column(name = "file_name")
    private String fileName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    public String getVacancyName() {
        return vacancy != null ? vacancy.getTitle() : "<none>";
    }
}
