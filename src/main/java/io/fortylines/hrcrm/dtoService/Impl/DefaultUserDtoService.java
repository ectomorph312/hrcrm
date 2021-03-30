package io.fortylines.hrcrm.dtoService.Impl;

import io.fortylines.hrcrm.dto.CreateUserDto;
import io.fortylines.hrcrm.dto.ReadUserDto;
import io.fortylines.hrcrm.dto.UpdateUserDto;
import io.fortylines.hrcrm.dtoService.UserDtoService;
import io.fortylines.hrcrm.entity.Role;
import io.fortylines.hrcrm.entity.User;
import io.fortylines.hrcrm.mapper.UserMapper;
import io.fortylines.hrcrm.service.RoleService;
import io.fortylines.hrcrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DefaultUserDtoService implements UserDtoService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserMapper userMapper;
    private final RoleService roleService;

    @Autowired
    public DefaultUserDtoService(PasswordEncoder passwordEncoder, UserService userService, UserMapper userMapper,
                                 RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userMapper = userMapper;
        this.roleService = roleService;
    }

    @Override
    public ReadUserDto create(CreateUserDto createUserDto) {
        int year = LocalDate.now().getYear();
        String username = ((createUserDto.getFirstName().substring(0, 3) + createUserDto.getLastName().substring(0, 3))
                + year).toLowerCase();
        Role role = roleService.getById(createUserDto.getRoleId());
        String password = passwordEncoder.encode(createUserDto.getPassword());

        User createUser = new User();
        createUser.setFirstName(createUserDto.getFirstName());
        createUser.setLastName(createUserDto.getLastName());
        createUser.setPassword(password);
        createUser.setUsername(username);
        createUser.setRoles(role);
        createUser.setActive(true);

        User responseUser = userService.create(createUser);
        return userMapper.toReadUserDto(responseUser);
    }

    @Override
    public ReadUserDto update(Long id, UpdateUserDto updateUserDto) {
        User updateUser = new User();
        boolean active = updateUserDto.isActive();
        Role role = roleService.getById(updateUserDto.getRoleId());

        updateUser.setFirstName(updateUserDto.getFirstName());
        updateUser.setLastName(updateUserDto.getLastName());
        updateUser.setActive(active);
        updateUser.setRoles(role);

        User userResponse = userService.update(id, updateUser);
        return userMapper.toReadUserDto(userResponse);
    }

    @Override
    public ReadUserDto getById(Long id) {
        User userResponse = userService.getById(id);
        return userMapper.toReadUserDto(userResponse);
    }

    @Override
    public Page<ReadUserDto> getAll(Pageable pageable) {
        Page<User> usersList = userService.getAll(pageable);
        return userMapper.toReadUserDtoList(usersList);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }
}
