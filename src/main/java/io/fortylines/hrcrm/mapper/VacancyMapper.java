package io.fortylines.hrcrm.mapper;

import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.entity.Vacancy;
import org.springframework.data.domain.Page;

public interface VacancyMapper {
    ReadVacancyDto toReadVacancydto(Vacancy vacancy);
    Page<ReadVacancyDto> toReadVacanciesDtoList(Page<Vacancy> vacancies);
}
