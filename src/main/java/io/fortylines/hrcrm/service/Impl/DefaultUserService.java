package io.fortylines.hrcrm.service.Impl;

import io.fortylines.hrcrm.entity.User;
import io.fortylines.hrcrm.repository.UserRepository;
import io.fortylines.hrcrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User with this id: " + id + " not found"));
    }

    @Override
    public User update(Long id, User user) {
        User updateUser = userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User with this id:" + id + " not found"));

        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setRole(user.getRole());
        updateUser.setActive(user.isActive());

        return userRepository.save(updateUser);
    }

    @Override
    public List<String> getAllEmailsByRoleId(Long roleId) {
        return userRepository.retrieveAllEmailsByRoleId(roleId);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}