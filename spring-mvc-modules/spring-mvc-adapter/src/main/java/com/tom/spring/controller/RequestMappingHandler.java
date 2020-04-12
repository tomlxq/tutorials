package com.tom.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/11
 */
@Controller
public class RequestMappingHandler {

    @RequestMapping("/requestName")
    public ModelAndView getEmployeeName() {
        ModelAndView model = new ModelAndView("Greeting");
        model.addObject("message", "Madhwal");
        return model;
    }
}
