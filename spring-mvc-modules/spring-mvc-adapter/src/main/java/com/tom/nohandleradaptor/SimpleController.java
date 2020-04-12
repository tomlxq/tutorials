package com.tom.nohandleradaptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/11
 */
public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("Greeting");
        model.addObject("message", "Dinesh Madhwal");
        return model;
    }
}