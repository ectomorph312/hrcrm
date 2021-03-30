package io.fortylines.hrcrm.repository;

import io.fortylines.hrcrm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
