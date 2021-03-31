package io.fortylines.hrcrm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String roleName;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<User> roles;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
