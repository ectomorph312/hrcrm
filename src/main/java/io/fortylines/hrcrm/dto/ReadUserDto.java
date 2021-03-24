package io.fortylines.hrcrm.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ReadUserDto {

    private String firstName;
    private String lastName;
    private String username;
    private Boolean active;
    private Set roles;
}
