package com.user.management.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * user status entity class
 *
 * @author parksangwon
 * @version 1.0.0
 */
@Entity
@Getter
@Table(name = "user_status")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Status {
    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status_name")
    private String name;

    /**
     * Instantiates a new Status.
     *
     * @param id   the id
     * @param name the name
     */
    @Builder
    public Status(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
