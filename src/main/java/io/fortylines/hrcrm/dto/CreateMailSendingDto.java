package io.fortylines.hrcrm.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateMailSendingDto {

    @NotNull
    private String subject;

    @NotNull
    private String text;

    @NotNull
    private Long roleId;
}
