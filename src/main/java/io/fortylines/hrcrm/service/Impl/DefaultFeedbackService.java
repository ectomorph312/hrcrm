package io.fortylines.hrcrm.service.Impl;

import io.fortylines.hrcrm.entity.Feedback;
import io.fortylines.hrcrm.repository.FeedbackRepository;
import io.fortylines.hrcrm.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DefaultFeedbackService implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public DefaultFeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback getById(Long id) {
        return feedbackRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Feedback with id: " + id + " not found"));
    }

    @Override
    public Feedback getByCandidateId(Long candidateId) {
        return feedbackRepository.retrieveFeedbackByCandidateId(candidateId);
    }

    @Override
    public void delete(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public Feedback update(Long id, Feedback feedback) {
        Feedback updFeedback = feedbackRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Feedback is not found"));

        updFeedback.setStrengths(feedback.getStrengths());
        updFeedback.setWeaknesses(feedback.getWeaknesses());
        updFeedback.setComments(feedback.getComments());
        updFeedback.setRatingScale(feedback.getRatingScale());

        return feedbackRepository.save(updFeedback);
    }
}
