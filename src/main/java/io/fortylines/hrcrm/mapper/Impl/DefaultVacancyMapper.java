package io.fortylines.hrcrm.mapper.Impl;

import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.entity.Vacancy;
import io.fortylines.hrcrm.mapper.VacancyMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class DefaultVacancyMapper implements VacancyMapper {

    @Override
    public ReadVacancyDto toReadVacancyDto(Vacancy vacancy) {
        ReadVacancyDto readVacancyDto = new ReadVacancyDto();

        readVacancyDto.setTitle(vacancy.getTitle());
        readVacancyDto.setDescription(vacancy.getDescription());
        readVacancyDto.setRequirements(vacancy.getRequirements());
        readVacancyDto.setCompetencies(vacancy.getCompetencies());
        readVacancyDto.setCreatedAt(vacancy.getCreatedAt());
        readVacancyDto.setAuthor(vacancy.getAuthorName());
        readVacancyDto.setIsOnInstagram(vacancy.isOnInstagram());
        readVacancyDto.setIsOnTelegram(vacancy.isOnTelegram());
        readVacancyDto.setIsOnJobkg(vacancy.isOnJobkg());
        readVacancyDto.setIsOnFacebook(vacancy.isOnFacebook());
        readVacancyDto.setIsOnDiesel(vacancy.isOnDiesel());

        return readVacancyDto;
    }

    @Override
    public Page<ReadVacancyDto> toReadVacanciesDtoList(Page<Vacancy> vacancies) {
        return vacancies.map(this::toReadVacancyDto);
    }
}
