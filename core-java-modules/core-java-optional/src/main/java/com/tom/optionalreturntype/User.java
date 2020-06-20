package com.tom.optionalreturntype;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {
    @Id
    private long userId;

    private String firstName;


}
