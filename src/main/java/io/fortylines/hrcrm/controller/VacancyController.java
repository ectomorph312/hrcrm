package io.fortylines.hrcrm.controller;

import io.fortylines.hrcrm.dto.CreateVacancyDto;
import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.dto.UpdateVacancyDto;
import io.fortylines.hrcrm.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/{id}")
    public ReadVacancyDto getVacancyProfile(@PathVariable Long id) {
        return vacancyService.getVacancyProfile(id);
    }

    @PostMapping("/{id}")
    public ReadVacancyDto createNewVacancy(@PathVariable Long id,
                                           @RequestBody @Validated CreateVacancyDto createVacancyDto) {
        return vacancyService.createNewVacancy(id, createVacancyDto);
    }

    @PutMapping("/{id}")
    public ReadVacancyDto updateVacancy(@PathVariable Long id,
                                        @RequestBody @Validated UpdateVacancyDto updateVacancyDto) {
        return vacancyService.updateVacancy(id, updateVacancyDto);
    }

    @GetMapping
    public Page<ReadVacancyDto> getAllVacancies(@PageableDefault(sort = {"created"}, direction = Sort.Direction.DESC, size = 15)
                                                            Pageable pageable) {
        return vacancyService.findAll(pageable);
    }

    @DeleteMapping("{id}")
    public void deleteVacancy(@PathVariable Long id) {
        vacancyService.delete(id);
    }
}
