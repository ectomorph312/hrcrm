package io.fortylines.hrcrm.service;

import io.fortylines.hrcrm.dto.CreateVacancyDto;
import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.dto.UpdateVacancyDto;
import io.fortylines.hrcrm.entity.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VacancyService {

    ReadVacancyDto getVacancyProfile(Long id);

    ReadVacancyDto createNewVacancy(Long id, CreateVacancyDto createVacancyDto);

    void delete(Long id);

    ReadVacancyDto updateVacancy(Long id, UpdateVacancyDto updateVacancyDto);

    Vacancy getById(Long id);

    Page<ReadVacancyDto> findAll(Pageable pageable);
}
