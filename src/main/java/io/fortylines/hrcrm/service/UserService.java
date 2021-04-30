package io.fortylines.hrcrm.service;

import io.fortylines.hrcrm.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User getById(Long id);
    Page<User> getAll(Pageable pageable);
    User create(User user);
    User update(Long id, User user);
    List<String> getAllEmailsByRoleId(Long roleId);
    void delete(Long id);
}