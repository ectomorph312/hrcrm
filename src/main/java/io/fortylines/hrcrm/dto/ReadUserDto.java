package io.fortylines.hrcrm.dto;

import io.fortylines.hrcrm.entity.Role;
import lombok.Data;

@Data
public class ReadUserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Boolean isActive;
    private Role role;
}
