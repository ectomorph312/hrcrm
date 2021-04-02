package io.fortylines.hrcrm.controller;

import io.fortylines.hrcrm.dto.CreateUserDto;
import io.fortylines.hrcrm.dto.ReadUserDto;
import io.fortylines.hrcrm.dto.UpdateUserDto;
import io.fortylines.hrcrm.dtoService.UserDtoService;
import io.fortylines.hrcrm.pageable.UserPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {

    private final UserDtoService userDtoService;

    @Autowired
    public UserController(UserDtoService userDtoService) {
        this.userDtoService = userDtoService;
    }

    @GetMapping("/{id}")
    public ReadUserDto getById(@PathVariable Long id) {
        return userDtoService.getById(id);
    }

    @PostMapping
    public ReadUserDto create(@RequestBody @Validated CreateUserDto createUserDto) {
        return userDtoService.create(createUserDto);
    }

    @PutMapping("/{id}")
    public ReadUserDto update(@PathVariable Long id, @RequestBody @Validated UpdateUserDto updateUserDto) {
        return userDtoService.update(id, updateUserDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userDtoService.delete(id);
    }

    @GetMapping
    public Page<ReadUserDto> getAll(UserPageRequest userPageRequest) {
        return userDtoService.getAll(userPageRequest);
    }
}