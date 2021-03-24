package io.fortylines.hrcrm.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateVacancyDto {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String requirements;

    @NotNull
    private String competencies;
}
