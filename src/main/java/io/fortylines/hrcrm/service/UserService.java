package io.fortylines.hrcrm.service;

import io.fortylines.hrcrm.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User getById(Long id);
    Page<User> getAll(Pageable pageable);
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
}