package io.fortylines.hrcrm.dtoService;

import io.fortylines.hrcrm.dto.CreateUserDto;
import io.fortylines.hrcrm.dto.ReadUserDto;
import io.fortylines.hrcrm.dto.UpdateUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDtoService {
    ReadUserDto create(CreateUserDto createUserDto);
    ReadUserDto update(Long id, UpdateUserDto updateUserDto);
    ReadUserDto getById(Long id);
    Page<ReadUserDto> getAll(Pageable pageable);
    void delete(Long id);
}
