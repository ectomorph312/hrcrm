package io.fortylines.hrcrm.mapper;

import io.fortylines.hrcrm.dto.ReadUserDto;
import io.fortylines.hrcrm.entity.User;
import org.springframework.data.domain.Page;

public interface UserMapper {
    ReadUserDto toReadUserDto(User user);
    Page<ReadUserDto> toReadUserDtoList(Page<User> user);
}
