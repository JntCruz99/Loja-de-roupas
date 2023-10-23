package com.example.Loja.de.roupas.Entity;

import com.example.Loja.de.roupas.Entity.enums.RoleName;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Table(name = "TB_ROLE")
@Data
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;

    public Role(RoleName roleName) {
    }

    public Role() {

    }


    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}