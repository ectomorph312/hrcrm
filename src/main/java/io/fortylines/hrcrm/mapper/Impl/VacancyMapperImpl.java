package io.fortylines.hrcrm.mapper.Impl;

import io.fortylines.hrcrm.dto.ReadVacancyDto;
import io.fortylines.hrcrm.entity.Vacancy;
import io.fortylines.hrcrm.mapper.VacancyMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class VacancyMapperImpl implements VacancyMapper {

    @Override
    public ReadVacancyDto toReadVacancydto(Vacancy vacancy) {
        ReadVacancyDto readVacancyDto = new ReadVacancyDto();
        readVacancyDto.setTitle(vacancy.getTitle());
        readVacancyDto.setDescription(vacancy.getDescription());
        readVacancyDto.setRequirements(vacancy.getRequirements());
        readVacancyDto.setCompetencies(vacancy.getCompetencies());
        readVacancyDto.setCreated(vacancy.getCreated());
        readVacancyDto.setAuthor(vacancy.getAuthorName());

        return readVacancyDto;
    }

    @Override
    public Page<ReadVacancyDto> toReadVacanciesDtoList(Page<Vacancy> vacancies) {
        return vacancies.map(this::toReadVacancydto);
    }
}
