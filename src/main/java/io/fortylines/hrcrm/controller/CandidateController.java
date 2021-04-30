package io.fortylines.hrcrm.controller;

import io.fortylines.hrcrm.dto.CreateCandidateDto;
import io.fortylines.hrcrm.dto.ReadCandidateDto;
import io.fortylines.hrcrm.dto.UpdateCandidateDto;
import io.fortylines.hrcrm.dtoService.CandidateDtoService;
import io.fortylines.hrcrm.pageable.CandidatePageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/candidates")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR')")
public class CandidateController {

    private final CandidateDtoService candidateDtoService;

    @Autowired
    public CandidateController(CandidateDtoService candidateDtoService) {
        this.candidateDtoService = candidateDtoService;
    }

    @PostMapping
    public ReadCandidateDto create(@RequestPart(value = "resume") MultipartFile resume,
                                   @RequestPart(value = "create") @Validated
                                           CreateCandidateDto createUserDto) throws IOException {
        return candidateDtoService.create(resume ,createUserDto);
    }

    @PutMapping("/{id}")
    public ReadCandidateDto update(@PathVariable Long id,
                                   @RequestPart(value = "resume", required = false) MultipartFile resume,
                                   @RequestPart(value = "update") @Validated
                                   UpdateCandidateDto updateCandidateDto) throws IOException {
        return candidateDtoService.update(id, resume, updateCandidateDto);
    }

    @GetMapping("/{id}")
    public ReadCandidateDto getById(@PathVariable Long id) {
        return candidateDtoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        candidateDtoService.delete(id);
    }

    @GetMapping
    public Page<ReadCandidateDto> getAll(CandidatePageRequest candidatePageRequest) {
        return candidateDtoService.getAll(candidatePageRequest);
    }
}
