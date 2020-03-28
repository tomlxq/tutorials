package com.tom.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class EmployeeControllerModelAttributeIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenUrlEncodedFormData_whenAddEmployeeEndpointCalled_thenModelContainsMsgAttribute() throws Exception {
        Collection<NameValuePair> formData = Arrays.asList(new BasicNameValuePair("name", "employeeName"), new BasicNameValuePair("id", "99"), new BasicNameValuePair("contactNumber", "123456789"));
        String urlEncodedFormData = EntityUtils.toString(new UrlEncodedFormEntity(formData));

        mockMvc.perform(post("/addEmployee").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(urlEncodedFormData))
                .andExpect(status().isOk())
                .andExpect(view().name("employeeView"))
                .andExpect(model().attribute("msg", "Welcome to the Netherlands!"));
    }

    @Test
    public void classic_controller() throws Exception {
        mockMvc.perform(get("/books/42").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"id\":42,\"author\":\"Douglas Adamas\",\"title\":\"Hitchhiker's guide to the galaxy\"}"));
    }
    @Test
    public void specialized_controller() throws Exception {
        mockMvc.perform(get("/books-rest/42").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("{\"id\":42,\"author\":\"Douglas Adamas\",\"title\":\"Hitchhiker's guide to the galaxy\"}"));
    }

}
