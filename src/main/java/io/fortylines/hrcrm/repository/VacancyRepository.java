package io.fortylines.hrcrm.repository;

import io.fortylines.hrcrm.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
