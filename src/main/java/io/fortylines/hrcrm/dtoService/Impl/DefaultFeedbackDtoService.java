package io.fortylines.hrcrm.dtoService.Impl;

import io.fortylines.hrcrm.dto.CreateFeedbackDto;
import io.fortylines.hrcrm.dto.ReadFeedbackDto;
import io.fortylines.hrcrm.dto.UpdateFeedbackDto;
import io.fortylines.hrcrm.dtoService.FeedbackDtoService;
import io.fortylines.hrcrm.entity.Candidate;
import io.fortylines.hrcrm.entity.Feedback;
import io.fortylines.hrcrm.mapper.FeedbackMapper;
import io.fortylines.hrcrm.service.CandidateService;
import io.fortylines.hrcrm.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFeedbackDtoService implements FeedbackDtoService {

    private final CandidateService candidateService;
    private final FeedbackService feedbackService;
    private final FeedbackMapper feedbackMapper;

    @Autowired
    public DefaultFeedbackDtoService(CandidateService candidateService, FeedbackService feedbackService,
                                     FeedbackMapper feedbackMapper) {
        this.candidateService = candidateService;
        this.feedbackService = feedbackService;
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public ReadFeedbackDto create(CreateFeedbackDto createFeedbackDto) {
        Feedback newFeedback = new Feedback();
        Candidate candidate = candidateService.getById(createFeedbackDto.getCandidateId());

        newFeedback.setStrengths(createFeedbackDto.getStrengths());
        newFeedback.setWeaknesses(createFeedbackDto.getWeaknesses());
        newFeedback.setComments(createFeedbackDto.getComments());
        newFeedback.setRatingScale(createFeedbackDto.getRatingScale());
        newFeedback.setCandidate(candidate);

        Feedback feedback = feedbackService.create(newFeedback);
        return feedbackMapper.toReadFeedbackDto(feedback);
    }

    @Override
    public ReadFeedbackDto getById(Long id) {
        Feedback feedback = feedbackService.getById(id);
        return feedbackMapper.toReadFeedbackDto(feedback);
    }

    @Override
    public ReadFeedbackDto update(Long id, UpdateFeedbackDto updateFeedbackDto) {
        Feedback updFeedback = new Feedback();

        updFeedback.setStrengths(updateFeedbackDto.getStrengths());
        updFeedback.setWeaknesses(updateFeedbackDto.getWeaknesses());
        updFeedback.setComments(updateFeedbackDto.getComments());
        updFeedback.setRatingScale(updateFeedbackDto.getRatingScale());

        Feedback feedback = feedbackService.update(id, updFeedback);
        return feedbackMapper.toReadFeedbackDto(feedback);
    }

    @Override
    public ReadFeedbackDto getFeedbackByCandidateId(Long id) {
        Feedback feedback = feedbackService.getByCandidateId(id);
        return feedbackMapper.toReadFeedbackDto(feedback);
    }

    @Override
    public void delete(Long id) {
        feedbackService.delete(id);
    }
}
