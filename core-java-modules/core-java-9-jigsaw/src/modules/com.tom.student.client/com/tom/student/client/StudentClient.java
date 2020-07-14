package com.tom.student.client;

import com.tom.student.service.StudentService;
import com.tom.student.service.dbimpl.StudentDbService;
import com.tom.student.model.Student;

public class StudentClient {

    public static void main(String[] args) {
        StudentService service = new StudentDbService();
        service.create(new Student());
        service.read("17SS0001");
        service.update(new Student());
        service.delete("17SS0001");
    }
}