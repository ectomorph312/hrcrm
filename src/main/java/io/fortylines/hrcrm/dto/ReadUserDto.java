package io.fortylines.hrcrm.dto;

import io.fortylines.hrcrm.entity.Role;
import lombok.Data;

@Data
public class ReadUserDto {

    private String firstName;
    private String lastName;
    private String username;
    private Boolean active;
    private Role role;
}
