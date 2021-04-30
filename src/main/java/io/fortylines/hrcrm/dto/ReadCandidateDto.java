package io.fortylines.hrcrm.dto;

import lombok.Data;

@Data
public class ReadCandidateDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String degree;
    private String department;
    private String discord;
    private String email;
    private String yearsOfExperience;
    private String vacancy;
}
