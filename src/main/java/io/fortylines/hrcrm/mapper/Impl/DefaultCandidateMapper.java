package io.fortylines.hrcrm.mapper.Impl;

import io.fortylines.hrcrm.dto.ReadCandidateDto;
import io.fortylines.hrcrm.entity.Candidate;
import io.fortylines.hrcrm.mapper.CandidateMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class DefaultCandidateMapper implements CandidateMapper {

    @Override
    public ReadCandidateDto toReadCandidateDto(Candidate candidate) {
        ReadCandidateDto readCandidateDto = new ReadCandidateDto();

        readCandidateDto.setFirstName(candidate.getFirstName());
        readCandidateDto.setLastName(candidate.getLastName());
        readCandidateDto.setPhoneNumber(candidate.getPhoneNumber());
        readCandidateDto.setDegree(candidate.getDegree());
        readCandidateDto.setDepartment(candidate.getDepartment());
        readCandidateDto.setDiscord(candidate.getDiscord());
        readCandidateDto.setEmail(candidate.getEmail());
        readCandidateDto.setYearsOfExperience(candidate.getYearsOfExperience());
        readCandidateDto.setVacancy(candidate.getVacancyName());

        return readCandidateDto;
    }

    @Override
    public Page<ReadCandidateDto> toReadCandidateDtoList(Page<Candidate> candidates) {
        return candidates.map(this::toReadCandidateDto);
    }
}
