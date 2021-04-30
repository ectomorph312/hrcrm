package io.fortylines.hrcrm.dtoService;

import io.fortylines.hrcrm.dto.CreateFeedbackDto;
import io.fortylines.hrcrm.dto.ReadFeedbackDto;
import io.fortylines.hrcrm.dto.UpdateFeedbackDto;

public interface FeedbackDtoService {
    ReadFeedbackDto create(CreateFeedbackDto createFeedbackDto);
    ReadFeedbackDto getById(Long id);
    ReadFeedbackDto update(Long id, UpdateFeedbackDto updateFeedbackDto);
    ReadFeedbackDto getFeedbackByCandidateId(Long id);
    void delete(Long id);
}
