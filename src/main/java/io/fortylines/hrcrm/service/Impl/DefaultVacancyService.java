package io.fortylines.hrcrm.service.Impl;

import io.fortylines.hrcrm.entity.Vacancy;
import io.fortylines.hrcrm.repository.VacancyRepository;
import io.fortylines.hrcrm.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DefaultVacancyService implements VacancyService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public DefaultVacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public Vacancy getById(Long id) {
        return vacancyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Vacancy with id: " + id + " not found"));
    }

    @Override
    public Vacancy create(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Page<Vacancy> getAll(Pageable pageable) {
        return vacancyRepository.findAll(pageable);
    }

    @Override
    public Vacancy update(Long id, Vacancy vacancy) {
        Vacancy updateVacancy = vacancyRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Vacancy with id: " + id + " not found"));

        updateVacancy.setTitle(vacancy.getTitle());
        updateVacancy.setDescription(vacancy.getDescription());
        updateVacancy.setRequirements(vacancy.getRequirements());
        updateVacancy.setUpdatedAt(vacancy.getUpdatedAt());
        updateVacancy.setCompetencies(vacancy.getCompetencies());
        updateVacancy.setOnInstagram(vacancy.isOnInstagram());
        updateVacancy.setOnTelegram(vacancy.isOnTelegram());
        updateVacancy.setOnJobkg(vacancy.isOnJobkg());
        updateVacancy.setOnFacebook(vacancy.isOnFacebook());
        updateVacancy.setOnDiesel(vacancy.isOnDiesel());

        return vacancyRepository.save(updateVacancy);
    }

    @Override
    public void delete(Long id) {
        vacancyRepository.deleteById(id);
    }
}