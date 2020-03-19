package com.tom.multipledb.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserMultipleDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer status;

    @OneToMany
    List<PossessionMultipleDB> possessionList;


    public UserMultipleDB(String name, String email, Integer status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }


}