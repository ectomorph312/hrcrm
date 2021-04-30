package io.fortylines.hrcrm.controller;

import io.fortylines.hrcrm.dto.CreateFeedbackDto;
import io.fortylines.hrcrm.dto.ReadFeedbackDto;
import io.fortylines.hrcrm.dto.UpdateFeedbackDto;
import io.fortylines.hrcrm.dtoService.FeedbackDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/feedbacks")
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_HR', 'ROLE_HEADOFDEPARTMENT')")
public class FeedbackController {

    private final FeedbackDtoService feedbackDtoService;

    @Autowired
    public FeedbackController(FeedbackDtoService feedbackDtoService) {
        this.feedbackDtoService = feedbackDtoService;
    }

    @PostMapping
    public ReadFeedbackDto create(@RequestBody @Validated CreateFeedbackDto createFeedbackDto) {
        return feedbackDtoService.create(createFeedbackDto);
    }

    @GetMapping("/{id}")
    public ReadFeedbackDto getById(@PathVariable Long id) {
        return feedbackDtoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        feedbackDtoService.delete(id);
    }

    @PutMapping("/{id}")
    public ReadFeedbackDto update(@PathVariable Long id,
                                  @RequestBody @Validated UpdateFeedbackDto updateFeedbackDto) {
        return feedbackDtoService.update(id, updateFeedbackDto);
    }

    @GetMapping("/search/{candidateId}")
    public ReadFeedbackDto getFeedbackByCandidateId(@PathVariable Long candidateId) {
        return feedbackDtoService.getFeedbackByCandidateId(candidateId);
    }
}
