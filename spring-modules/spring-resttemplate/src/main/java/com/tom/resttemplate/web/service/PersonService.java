package com.tom.resttemplate.web.service;

import com.tom.resttemplate.web.dto.Person;

public interface PersonService {

    public Person saveUpdatePerson(Person person);

    public Person findPersonById(Integer id);
}