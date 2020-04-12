package com.guava.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/7
 */
public class CustomMVCValidatorIntegrationTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ValidatedPhoneController())
                .build();
    }

    @Test
    public void givenPhonePageUri_whenMockMvc_thenReturnsPhonePage() throws Exception {
        this.mockMvc.perform(get("/validatePhone"))
                .andExpect(view().name("phoneHome"));
    }

    @Test
    public void givenPhoneURIWithPostAndFormData_whenMockMVC_thenVerifyErrorResponse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/addValidatePhone")
                .accept(MediaType.TEXT_HTML)
                .param("phone", "123").param("name", "guava"))
                .andExpect(model().attributeHasFieldErrorCode("userInfo", "phone", "ContactNumberConstraint"))
                .andExpect(view().name("phoneHome"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}