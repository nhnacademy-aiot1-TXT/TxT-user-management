package com.user.management.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_role")
public class Role {
    @Id
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String name;

    @Builder
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
