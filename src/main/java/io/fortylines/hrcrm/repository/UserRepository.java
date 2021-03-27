package io.fortylines.hrcrm.repository;

import io.fortylines.hrcrm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
