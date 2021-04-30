package io.fortylines.hrcrm.service;

import io.fortylines.hrcrm.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CandidateService {
    Candidate create(Candidate candidate);
    Candidate update(Long id, MultipartFile multipartFile, Candidate candidate) throws IOException;
    Candidate getById(Long id);
    Page<Candidate> getAll(Pageable pageable);
    void delete(Long id);
}
