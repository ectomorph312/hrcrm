package io.fortylines.hrcrm.dtoService;

import io.fortylines.hrcrm.dto.CreateVacancyDto;
import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.dto.UpdateVacancyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VacancyDtoService {
    ReadVacancyDto getById(Long id);
    ReadVacancyDto create(Long user_id, CreateVacancyDto createVacancyDto);
    Page<ReadVacancyDto> getAll(Pageable pageable);
    ReadVacancyDto update(Long id, UpdateVacancyDto updateVacancyDto);
    void delete(Long id);
}
