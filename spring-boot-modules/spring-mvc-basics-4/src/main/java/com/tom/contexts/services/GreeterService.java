package com.tom.contexts.services;

import com.tom.contexts.Greeting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GreeterService {

    @Resource
    private Greeting greeting;

    public String greet() {
        return greeting.getMessage();
    }

}
