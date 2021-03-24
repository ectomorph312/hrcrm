package io.fortylines.hrcrm.controller;

import io.fortylines.hrcrm.dto.CreateUserDto;
import io.fortylines.hrcrm.dto.ReadUserDto;
import io.fortylines.hrcrm.dto.UpdateUserDto;
import io.fortylines.hrcrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ReadUserDto getUserProfile(@PathVariable Long id) {
        return userService.getUserProfile(id);
    }

    @PostMapping
    public ReadUserDto createNewUser(@RequestBody @Validated CreateUserDto createUserDto) {
        return userService.createNewUser(createUserDto);
    }

    @PutMapping("/{id}")
    public ReadUserDto update(@PathVariable Long id, @RequestBody @Validated UpdateUserDto updateUserDto) {
        return userService.update(id, updateUserDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping
    public Page<ReadUserDto> getAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC,size = 15)
                                                Pageable pageable) {
        return userService.findAll(pageable);
    }
}
