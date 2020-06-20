package com.tom.inmemory.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ManyTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "manyTags")
    private Set<ManyStudent> students = new HashSet<>();

    public ManyTag() {
    }

    public ManyTag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ManyStudent> getStudents() {
        return students;
    }

    public void setStudents(Set<ManyStudent> students) {
        this.students.addAll(students);
    }
}
