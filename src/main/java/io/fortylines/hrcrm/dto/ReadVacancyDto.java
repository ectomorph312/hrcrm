package io.fortylines.hrcrm.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ReadVacancyDto {
    private String title;
    private String description;
    private String requirements;
    private Set competencies;
    private LocalDateTime created;
    private String author;
}
