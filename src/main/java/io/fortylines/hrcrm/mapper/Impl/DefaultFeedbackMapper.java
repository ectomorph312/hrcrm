package io.fortylines.hrcrm.mapper.Impl;

import io.fortylines.hrcrm.dto.ReadFeedbackDto;
import io.fortylines.hrcrm.entity.Feedback;
import io.fortylines.hrcrm.mapper.FeedbackMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultFeedbackMapper implements FeedbackMapper {
    @Override
    public ReadFeedbackDto toReadFeedbackDto(Feedback feedback) {
        ReadFeedbackDto readFeedbackDto = new ReadFeedbackDto();

        readFeedbackDto.setWeaknesses(feedback.getWeaknesses());
        readFeedbackDto.setStrengths(feedback.getStrengths());
        readFeedbackDto.setComments(feedback.getComments());
        readFeedbackDto.setRatingScale(feedback.getRatingScale());
        readFeedbackDto.setCandidate(feedback.getCandidateName());

        return readFeedbackDto;
    }
}
