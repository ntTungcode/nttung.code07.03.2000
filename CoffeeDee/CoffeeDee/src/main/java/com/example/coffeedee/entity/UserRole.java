package com.example.coffeedee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_role", schema = "coffee_dee")
public class UserRole extends BaseEntity{
    @Basic
    @Column(name = "role_name")
    private String roleName;

    @OneToOne(mappedBy = "userRoleId", cascade = CascadeType.ALL)
    private User userId;
}
