package com.tom.web.controller;

import com.tom.web.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAnnotatedController {

    @GetMapping(value = "/annotated/student/{studentId}")
    public Student getData(@PathVariable Integer studentId) {
        Student student = new Student();
        student.setName("Peter");
        student.setId(studentId);

        return student;
    }
}
