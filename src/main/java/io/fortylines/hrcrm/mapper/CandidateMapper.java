package io.fortylines.hrcrm.mapper;

import io.fortylines.hrcrm.dto.ReadCandidateDto;
import io.fortylines.hrcrm.entity.Candidate;
import org.springframework.data.domain.Page;

public interface CandidateMapper {
    ReadCandidateDto toReadCandidateDto(Candidate candidate);
    Page<ReadCandidateDto> toReadCandidateDtoList(Page<Candidate> candidates);
}
