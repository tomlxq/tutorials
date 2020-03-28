package com.tom.controllers;

import com.tom.SpringBootRestApplication;
import com.tom.requestresponsebody.ExamplePostController;
import com.tom.requestresponsebody.LoginForm;
import com.tom.services.ExampleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestApplication.class)
public class ExamplePostControllerRequestIntegrationTest {

    MockMvc mockMvc;
    @Mock
    private ExampleService exampleService;
    @InjectMocks
    private ExamplePostController exampleController;


    private LoginForm lf = new LoginForm();

    @Before
    public void preTest() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(exampleController)
                .build();
        lf.setPassword("password");
        lf.setUsername("username");
    }

    @Test
    public void requestBodyTest() throws Exception {
        when(exampleService.fakeAuthenticate(lf)).thenReturn(true);
        mockMvc
                .perform(post("/post/request")
                        .content(jsonBody)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    private final String jsonBody = "{\"username\": \"username\", \"password\": \"password\"}";
    @Test
    public void requestJsonBodyTest() throws Exception {
        when(exampleService.fakeAuthenticate(lf)).thenReturn(true);
        mockMvc
                .perform(post("/post/contentJson")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
        .andExpect(content().string("{\"text\":\"JSON Content!\"}"));
    }
    private final String xmlBody = "<loginForm><username>username</username><password>password</password></loginForm>";
    @Test
    public void requestXmlBodyTest() throws Exception {
        when(exampleService.fakeAuthenticate(lf)).thenReturn(true);
        mockMvc
                .perform(post("/post/contentXml")
                        .content(xmlBody)
                        .contentType(MediaType.APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("<ResponseTransfer><text>XML Content!</text></ResponseTransfer>"));
    }
}