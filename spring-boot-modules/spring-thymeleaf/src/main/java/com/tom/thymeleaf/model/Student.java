package com.tom.thymeleaf.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Simple student POJO with few fields
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -8582553475226281591L;
    @NotNull(message = "Student ID is required.")
    @Min(value = 1000, message = "Student ID must be at least 4 digits.")
    private Integer id;
    @NotNull(message = "Student name is required.")
    private String name;
    @NotNull(message = "Student gender is required.")
    private Character gender;
    private Float percentage;
}
