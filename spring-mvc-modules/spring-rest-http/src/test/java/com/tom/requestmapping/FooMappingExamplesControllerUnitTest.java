package com.tom.requestmapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FooMappingExamplesController.class)
public class FooMappingExamplesControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenAcceptsTextHtml_whenGet_thenTextHtmlReturned() throws Exception {
        mvc.perform(get("/ex/foos")
                .accept(MediaType.TEXT_HTML_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().string("Simple Get some Foos"));
    }


    @Test
    public void givenAcceptsJson_whenGetDuplicate_thenJsonResponseReturned() throws Exception {
        mvc.perform(get("/ex/foos/duplicate")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"message\":\"Duplicate\"}"));
    }

    @Test
    public void givenAcceptsXml_whenGetDuplicate_thenXmlResponseReturned() throws Exception {
        mvc.perform(get("/ex/foos/duplicate")
                .accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(content().string("<message>Duplicate</message>"));
    }
}
