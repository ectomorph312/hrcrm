package io.fortylines.hrcrm.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateMailDto {

    @NotNull
    private String toAddress;

    @NotNull
    private String subject;

    @NotNull
    private String text;
}
