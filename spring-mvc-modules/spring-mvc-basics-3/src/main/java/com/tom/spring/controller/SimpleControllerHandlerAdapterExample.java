package com.tom.spring.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleControllerHandlerAdapterExample extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("Greeting");
        model.addObject("message", "Dinesh Madhwal");
        return model;
    }
}