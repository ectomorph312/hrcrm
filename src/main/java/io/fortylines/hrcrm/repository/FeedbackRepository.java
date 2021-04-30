package io.fortylines.hrcrm.repository;

import io.fortylines.hrcrm.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query("SELECT u FROM Feedback u WHERE u.candidate.id = :candidateId")
    Feedback retrieveFeedbackByCandidateId(Long candidateId);
}
