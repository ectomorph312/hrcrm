package io.fortylines.hrcrm.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateFeedbackDto {

    @NotNull
    private String strengths;

    @NotNull
    private String weaknesses;

    @NotNull
    private String comments;

    @NotNull
    private Integer ratingScale;
}
