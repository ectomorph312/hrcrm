package io.fortylines.hrcrm.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateCandidateDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String degree;

    @NotNull
    private String department;

    @NotNull
    private String discord;

    @NotNull
    private String email;

    @NotNull
    private String yearsOfExperience;

    @NotNull
    private Long vacancyId;
}
