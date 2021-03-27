package io.fortylines.hrcrm.dto;

import io.fortylines.hrcrm.entity.Competencies;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReadVacancyDto {
    private String title;
    private String description;
    private String requirements;
    private List<Competencies> competencies;
    private LocalDateTime createdAt;
    private String author;
}
