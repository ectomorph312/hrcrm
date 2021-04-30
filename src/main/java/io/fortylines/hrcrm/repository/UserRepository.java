package io.fortylines.hrcrm.repository;

import io.fortylines.hrcrm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query("SELECT u.email FROM User u WHERE u.role.id = :roleId")
    List<String> retrieveAllEmailsByRoleId(Long roleId);
}
