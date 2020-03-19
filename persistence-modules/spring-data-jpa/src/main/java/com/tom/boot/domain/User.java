package com.tom.boot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate creationDate;
    private LocalDate lastLoginDate;
    private boolean active;
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer status;
    @OneToMany
    List<Possession> possessionList;


    public User(String name, LocalDate creationDate, String email, Integer status) {
        this.name = name;
        this.creationDate = creationDate;
        this.email = email;
        this.status = status;
        this.active = true;
    }


}