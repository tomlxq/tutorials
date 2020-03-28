package com.tom.services;

import org.springframework.stereotype.Service;

import com.tom.requestresponsebody.LoginForm;

@Service
public class ExampleService {

    public boolean fakeAuthenticate(LoginForm lf) {
        return true;
    }
}