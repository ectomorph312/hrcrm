package io.fortylines.hrcrm.service;

import io.fortylines.hrcrm.entity.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VacancyService {
    Vacancy getById(Long id);
    Vacancy create(Vacancy vacancy);
    Page<Vacancy> getAll(Pageable pageable);
    Vacancy update(Long id, Vacancy vacancy);
    void delete(Long id);
}