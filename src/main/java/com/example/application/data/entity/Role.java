package com.example.application.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE")
    private String role;
}
