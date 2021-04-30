package io.fortylines.hrcrm.dtoService.Impl;

import io.fortylines.hrcrm.dto.CreateVacancyDto;
import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.dto.UpdateVacancyDto;
import io.fortylines.hrcrm.dtoService.VacancyDtoService;
import io.fortylines.hrcrm.entity.User;
import io.fortylines.hrcrm.entity.Vacancy;
import io.fortylines.hrcrm.mapper.VacancyMapper;
import io.fortylines.hrcrm.service.UserService;
import io.fortylines.hrcrm.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DefaultVacancyDtoService implements VacancyDtoService {

    private final UserService userService;
    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;

    @Autowired
    public DefaultVacancyDtoService(UserService userService, VacancyService vacancyService,
                                    VacancyMapper vacancyMapper) {
        this.userService = userService;
        this.vacancyService = vacancyService;
        this.vacancyMapper = vacancyMapper;
    }

    @Override
    public ReadVacancyDto getById(Long id) {
        Vacancy vacancy = vacancyService.getById(id);
        return vacancyMapper.toReadVacancyDto(vacancy);
    }

    @Override
    public ReadVacancyDto create(CreateVacancyDto createVacancyDto) {
        Vacancy newVacancy = new Vacancy();
        User author = userService.getById(createVacancyDto.getUserId());

        newVacancy.setTitle(createVacancyDto.getTitle());
        newVacancy.setDescription(createVacancyDto.getDescription());
        newVacancy.setRequirements(createVacancyDto.getRequirements());
        newVacancy.setCreatedAt(LocalDateTime.now());
        newVacancy.setAuthor(author);
        newVacancy.setCompetencies(createVacancyDto.getCompetencies());

        Vacancy vacancy = vacancyService.create(newVacancy);
        return vacancyMapper.toReadVacancyDto(vacancy);
    }

    @Override
    public Page<ReadVacancyDto> getAll(Pageable pageable) {
        Page<Vacancy> vacancies = vacancyService.getAll(pageable);
        return vacancyMapper.toReadVacanciesDtoList(vacancies);
    }

    @Override
    public ReadVacancyDto update(Long id, UpdateVacancyDto updateVacancyDto) {
        Vacancy updateVacancy = new Vacancy();

        updateVacancy.setTitle(updateVacancyDto.getTitle());
        updateVacancy.setDescription(updateVacancyDto.getDescription());
        updateVacancy.setRequirements(updateVacancyDto.getRequirements());
        updateVacancy.setUpdatedAt(LocalDateTime.now());
        updateVacancy.setCompetencies(updateVacancyDto.getCompetencies());
        updateVacancy.setOnInstagram(updateVacancyDto.getIsOnInstagram());
        updateVacancy.setOnTelegram(updateVacancyDto.getIsOnTelegram());
        updateVacancy.setOnJobkg(updateVacancyDto.getIsOnJobkg());
        updateVacancy.setOnFacebook(updateVacancyDto.getIsOnFacebook());
        updateVacancy.setOnDiesel(updateVacancyDto.getIsOnDiesel());

        Vacancy vacancy = vacancyService.update(id, updateVacancy);
        return vacancyMapper.toReadVacancyDto(vacancy);
    }

    @Override
    public void delete(Long id) {
        vacancyService.delete(id);
    }
}
