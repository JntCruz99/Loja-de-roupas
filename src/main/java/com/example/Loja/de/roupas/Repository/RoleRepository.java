package com.example.Loja.de.roupas.Repository;

import com.example.Loja.de.roupas.Entity.Role;
import com.example.Loja.de.roupas.Entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}
