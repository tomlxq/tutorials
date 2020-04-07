/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/3
 */
package com.guava.controller;

import com.alibaba.fastjson.JSON;
import com.guava.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 */
@Controller
@Slf4j
public class UserController {

    @RequestMapping("/create")
    public String Create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String Save(@ModelAttribute("user") User user, Model model) { // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        model.addAttribute("user", user);
        log.info("{}", JSON.toJSONString(user, true));
        return "detail";
    }
}
