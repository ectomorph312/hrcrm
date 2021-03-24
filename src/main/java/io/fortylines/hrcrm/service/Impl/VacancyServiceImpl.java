package io.fortylines.hrcrm.service.Impl;

import io.fortylines.hrcrm.dto.CreateVacancyDto;
import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.dto.UpdateVacancyDto;
import io.fortylines.hrcrm.entity.Competencies;
import io.fortylines.hrcrm.entity.User;
import io.fortylines.hrcrm.entity.Vacancy;
import io.fortylines.hrcrm.mapper.VacancyMapper;
import io.fortylines.hrcrm.repository.VacancyRepository;
import io.fortylines.hrcrm.service.UserService;
import io.fortylines.hrcrm.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private VacancyMapper vacancyMapper;

    @Autowired
    private UserService userService;

    @Override
    public Vacancy getById(Long id) {
        Optional<Vacancy> optionalVacancy = vacancyRepository.findById(id);
        return optionalVacancy.orElseThrow(() -> new EntityNotFoundException("User with this id: " + id + " not found"));
    }

    @Override
    public Page<ReadVacancyDto> findAll(Pageable pageable) {
        return vacancyMapper.toReadVacanciesDtoList(vacancyRepository.findAll(pageable));
    }

    @Override
    public ReadVacancyDto getVacancyProfile(Long id) {
        Optional<Vacancy> optionalVacancy = vacancyRepository.findById(id);
        Vacancy vacancy = optionalVacancy.orElseThrow(() -> new EntityNotFoundException("Vacancy is not found"));

        return vacancyMapper.toReadVacancydto(vacancy);
    }

    @Override
    public ReadVacancyDto createNewVacancy(Long id, CreateVacancyDto createVacancyDto) {
        Vacancy vacancy = new Vacancy();
        User user = userService.getById(id);
        String competencies = createVacancyDto.getCompetencies();

        vacancy.setTitle(createVacancyDto.getTitle());
        vacancy.setDescription(createVacancyDto.getDescription());
        vacancy.setRequirements(createVacancyDto.getRequirements());
        vacancy.setCreated(LocalDateTime.now());
        vacancy.setAuthor(user);

        Set<String> competenciesList = Arrays.stream(Competencies.values())
                .map(Competencies::toString)
                .collect(Collectors.toSet());

        for (String competence : competenciesList) {
            if (competence.equalsIgnoreCase(competencies)) {
                vacancy.setCompetencies(Collections.singleton(Competencies.valueOf(competence)));
            }
        }

        Vacancy savedVacancy = vacancyRepository.save(vacancy);
        return vacancyMapper.toReadVacancydto(savedVacancy);
    }

    @Override
    public void delete(Long id) {
        vacancyRepository.deleteById(id);
    }

    @Override
    public ReadVacancyDto updateVacancy(Long id, UpdateVacancyDto updateVacancyDto) {
        Vacancy vacancy = getById(id);
        String newCompetences = updateVacancyDto.getCompetencies();

        vacancy.setTitle(updateVacancyDto.getTitle());
        vacancy.setDescription(updateVacancyDto.getDescription());
        vacancy.setModified(LocalDateTime.now());
        vacancy.setRequirements(updateVacancyDto.getRequirements());

        Set<String> competences = Arrays.stream(Competencies.values())
                .map(Competencies::toString)
                .collect(Collectors.toSet());

        for (String competencesTemp : competences) {
            if (competencesTemp.equalsIgnoreCase(newCompetences)) {
                vacancy.getCompetencies().add(Competencies.valueOf(competencesTemp));
            }
        }

        Vacancy savedVacancy = vacancyRepository.save(vacancy);
        return vacancyMapper.toReadVacancydto(savedVacancy);
    }

}


































