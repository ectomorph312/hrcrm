package io.fortylines.hrcrm.dto;

import io.fortylines.hrcrm.entity.Competencies;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateVacancyDto {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String requirements;

    @NotNull
    private List<Competencies> competencies;

    @NotNull
    private Boolean isOnInstagram;

    @NotNull
    private Boolean isOnTelegram;

    @NotNull
    private Boolean isOnJobkg;

    @NotNull
    private Boolean isOnFacebook;

    @NotNull
    private Boolean isOnDiesel;

    @NotNull
    private Long userId;
}
