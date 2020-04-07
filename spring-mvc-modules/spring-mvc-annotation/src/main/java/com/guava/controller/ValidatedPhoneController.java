package com.guava.controller;

import com.guava.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/6
 */
@Controller
public class ValidatedPhoneController {

    @GetMapping("/validatePhone")
    public String loadFormPage(Model m) {
        m.addAttribute("validatedPhone", new UserInfo());
        return "phoneHome";
    }

    @PostMapping("/addValidatePhone")
    public String submitForm(@Valid UserInfo userInfo,
                             BindingResult result, Model m) {
        if (result.hasErrors()) {
            return "phoneHome";
        }
        m.addAttribute("message", "Successfully saved phone: "
                + userInfo);
        return "phoneHome";
    }
}