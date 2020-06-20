package com.tom.boot.naming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Account {

    @OneToMany
    List<Preference> preferences;
    @Id
    private Long id;
    private String defaultEmail;
    @Column(name = "\"Secondary_Email\"")
    private String secondaryEmail;
}
