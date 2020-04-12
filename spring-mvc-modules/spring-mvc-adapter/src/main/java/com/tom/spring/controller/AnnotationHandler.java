package com.tom.spring.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AnnotationHandler {
    @RequestMapping("/annotedName")
    public ModelAndView getEmployeeName() {
        ModelAndView model = new ModelAndView("Greeting");
        model.addObject("message", "Dinesh");
        return model;
    }
}
