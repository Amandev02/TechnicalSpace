package com.example.TechnicalSpace.repositories;

import com.example.TechnicalSpace.models.AppRole;
import com.example.TechnicalSpace.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(AppRole appRole);

}
