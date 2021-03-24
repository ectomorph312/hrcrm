package io.fortylines.hrcrm.service.Impl;

import io.fortylines.hrcrm.dto.CreateUserDto;
import io.fortylines.hrcrm.dto.ReadUserDto;
import io.fortylines.hrcrm.dto.UpdateUserDto;
import io.fortylines.hrcrm.entity.Role;
import io.fortylines.hrcrm.entity.User;
import io.fortylines.hrcrm.mapper.UserMapper;
import io.fortylines.hrcrm.repository.UserRepository;
import io.fortylines.hrcrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ReadUserDto getUserProfile(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User is not found"));

        return userMapper.toReadUserDto(user);
    }

    @Override
    public User getById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new EntityNotFoundException("User with this id: " + id + " not found"));
    }

    @Override
    public ReadUserDto createNewUser(CreateUserDto createUserDto) {
        User user = new User();
        String username = (createUserDto.getFirstName() + createUserDto.getLastName()).toLowerCase();
        String role = createUserDto.getRoles().toUpperCase();

        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setPassword(createUserDto.getPassword());
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
        user.setUsername(username.replaceAll("\\s+",""));
        user.setActive(true);

        if (role.equals("HR") || role.equals("ADMIN") || role.equals("HEADOFDEPARTMENT")) {
            user.setRoles(Collections.singleton(Role.valueOf(role)));
        } else {
            throw new IllegalArgumentException("Role not found");
        }

        User savedUser = userRepository.save(user);
        return userMapper.toReadUserDto(savedUser);
    }

    @Override
    public ReadUserDto update(Long id, UpdateUserDto updateUserDto) {
        User user = getById(id);
        String deactivate = updateUserDto.getActive();
        String newRole = updateUserDto.getRoles().toUpperCase();

        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setPassword(updateUserDto.getPassword());

        if (deactivate.equalsIgnoreCase("true") || deactivate.equalsIgnoreCase("false"))
            user.setActive(Boolean.parseBoolean(deactivate));

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::getAuthority)
                .collect(Collectors.toSet());

        for (String key : roles) {
            if (key.equalsIgnoreCase(newRole)) {
                user.getRoles().clear();
                user.getRoles().add(Role.valueOf(newRole));
            }
        }

        User updateUser = userRepository.save(user);
        return userMapper.toReadUserDto(updateUser);
    }

    @Override
    public Page<ReadUserDto> findAll(Pageable pageable) {
        return userMapper.toReadUserDtoList(userRepository.findAll(pageable));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}












































