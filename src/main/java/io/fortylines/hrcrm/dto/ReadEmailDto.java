package io.fortylines.hrcrm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReadEmailDto {
    private Long msgId;
    private String from;
    private String subject;
    private String text;
    private String fileName;
    private Integer size;
    private Date receivedAt;
}
