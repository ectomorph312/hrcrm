package io.fortylines.hrcrm.controller;

import io.fortylines.hrcrm.dto.CreateVacancyDto;
import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.dto.UpdateVacancyDto;
import io.fortylines.hrcrm.dtoService.VacancyDtoService;
import io.fortylines.hrcrm.pageable.VacancyPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vacancies")
public class VacancyController {

    private final VacancyDtoService vacancyDtoService;

    @Autowired
    public VacancyController(VacancyDtoService vacancyDtoService) {
        this.vacancyDtoService = vacancyDtoService;
    }

    @GetMapping("/{id}")
    public ReadVacancyDto getById(@PathVariable Long id) {
        return vacancyDtoService.getById(id);
    }

    @PostMapping
    public ReadVacancyDto create(@RequestBody @Validated CreateVacancyDto createVacancyDto) {
        return vacancyDtoService.create(createVacancyDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        vacancyDtoService.delete(id);
    }

    @GetMapping
    public Page<ReadVacancyDto> getAll(VacancyPageRequest vacancyPageRequest) {
        return vacancyDtoService.getAll(vacancyPageRequest);
    }

    @PutMapping("/{id}")
    public ReadVacancyDto update(@PathVariable Long id,
                                        @RequestBody @Validated UpdateVacancyDto updateVacancyDto) {
        return vacancyDtoService.update(id, updateVacancyDto);
    }
}
