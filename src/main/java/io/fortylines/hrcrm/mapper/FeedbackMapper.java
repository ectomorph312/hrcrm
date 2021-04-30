package io.fortylines.hrcrm.mapper;

import io.fortylines.hrcrm.dto.ReadFeedbackDto;
import io.fortylines.hrcrm.entity.Feedback;

public interface FeedbackMapper {
    ReadFeedbackDto toReadFeedbackDto(Feedback feedback);
}
