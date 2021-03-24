package io.fortylines.hrcrm.service;

import io.fortylines.hrcrm.dto.CreateUserDto;
import io.fortylines.hrcrm.dto.ReadUserDto;
import io.fortylines.hrcrm.dto.UpdateUserDto;
import io.fortylines.hrcrm.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    ReadUserDto getUserProfile(Long id);

    User getById(Long id);

    ReadUserDto createNewUser(CreateUserDto createUserDto);

    ReadUserDto update(Long id, UpdateUserDto updateUserDto);

    Page<ReadUserDto> findAll(Pageable pageable);

    void delete(Long id);
}
