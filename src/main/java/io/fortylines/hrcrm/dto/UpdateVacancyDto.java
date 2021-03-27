package io.fortylines.hrcrm.dto;

import io.fortylines.hrcrm.entity.Competencies;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateVacancyDto {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String requirements;

    @NotNull
    private List<Competencies> competencies;
}
