package com.guava.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/8
 */
public class ClassValidationMvcTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new NewUserController()).build();
    }

    @Test
    public void givenMatchingEmailPassword_whenPostNewUserForm_thenOk()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .accept(MediaType.TEXT_HTML)
                .param("email", "john@yahoo.com")
                .param("verifyEmail", "john@yahoo.com")
                .param("password", "pass")
                .param("verifyPassword", "pass"))
                .andExpect(model().errorCount(0))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNotMatchingEmailPassword_whenPostNewUserForm_thenOk()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .accept(MediaType.TEXT_HTML)
                .param("email", "john@yahoo.com")
                .param("verifyEmail", "john@yahoo.commmm")
                .param("password", "pass")
                .param("verifyPassword", "passsss"))
                .andExpect(model().errorCount(2))
                .andExpect(status().isOk());
    }
}