package com.tom.web.controller;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/17
 */


import com.tom.web.dto.Bar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/bars")
public class BarController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public BarController() {
        super();
    }

    // API

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Bar findOne(@PathVariable("id") final Long id) {
        return new Bar();
    }

}

