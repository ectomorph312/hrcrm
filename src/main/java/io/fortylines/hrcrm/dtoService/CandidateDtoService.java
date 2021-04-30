package io.fortylines.hrcrm.dtoService;

import io.fortylines.hrcrm.dto.CreateCandidateDto;
import io.fortylines.hrcrm.dto.ReadCandidateDto;
import io.fortylines.hrcrm.dto.UpdateCandidateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CandidateDtoService {
    ReadCandidateDto create(MultipartFile multipartFile, CreateCandidateDto createCandidateDto) throws IOException;
    ReadCandidateDto update(Long id, MultipartFile multipartFile, UpdateCandidateDto updateCandidateDto) throws IOException;
    ReadCandidateDto getById(Long id);
    Page<ReadCandidateDto> getAll(Pageable pageable);
    void delete(Long id);
}
