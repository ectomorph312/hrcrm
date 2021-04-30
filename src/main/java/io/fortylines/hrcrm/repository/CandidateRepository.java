package io.fortylines.hrcrm.repository;

import io.fortylines.hrcrm.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
