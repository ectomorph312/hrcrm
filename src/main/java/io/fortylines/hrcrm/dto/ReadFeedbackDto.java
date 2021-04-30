package io.fortylines.hrcrm.dto;

import lombok.Data;

@Data
public class ReadFeedbackDto {
    private String strengths;
    private String weaknesses;
    private String comments;
    private Integer ratingScale;
    private String candidate;
}
