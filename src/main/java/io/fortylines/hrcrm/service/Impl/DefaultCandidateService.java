package io.fortylines.hrcrm.service.Impl;

import io.fortylines.hrcrm.entity.Candidate;
import io.fortylines.hrcrm.repository.CandidateRepository;
import io.fortylines.hrcrm.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DefaultCandidateService implements CandidateService {

    @Value("${file.upload.dir}")
    public String FILE_DIRECTORY;

    private final CandidateRepository candidateRepository;

    @Autowired
    public DefaultCandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Candidate create(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate update(Long id, MultipartFile resume, Candidate candidate) throws IOException {
        Candidate updateCandidate = candidateRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Candidate is not found"));

        if (resume != null) {
            String dateNow = LocalDateTime.now().withNano(0).withSecond(0).toString().replaceAll(":","-");
            String fileName = dateNow + "_" + resume.getOriginalFilename();
            resume.transferTo(new File(FILE_DIRECTORY + fileName));
            updateCandidate.setFileName(fileName);
        }

        updateCandidate.setFirstName(candidate.getFirstName());
        updateCandidate.setLastName(candidate.getLastName());
        updateCandidate.setPhoneNumber(candidate.getPhoneNumber());
        updateCandidate.setDegree(candidate.getDegree());
        updateCandidate.setDepartment(candidate.getDepartment());
        updateCandidate.setDiscord(candidate.getDiscord());
        updateCandidate.setEmail(candidate.getEmail());
        updateCandidate.setYearsOfExperience(candidate.getYearsOfExperience());
        updateCandidate.setVacancy(candidate.getVacancy());

        return candidateRepository.save(updateCandidate);
    }

    @Override
    public Candidate getById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Candidate is not found"));
    }

    @Override
    public Page<Candidate> getAll(Pageable pageable) {
        return candidateRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        candidateRepository.deleteById(id);
    }
}
