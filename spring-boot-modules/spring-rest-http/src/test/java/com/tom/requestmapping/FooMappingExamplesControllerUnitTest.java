package com.tom.requestmapping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FooMappingExamplesController.class)
public class FooMappingExamplesControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    /*
        @RequestMapping(value = "/foos", headers = "key=val")
        @ResponseBody
        public String getFoosWithHeader() {
            return "Get some Foos with Header";
        }
        */
    @Test
    public void givenAcceptsString() throws Exception {
        mvc.perform(get("/ex/foos").header("key", "val")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("Get some Foos with Header"));
    }

    @Test
    public void givenAcceptsString2() throws Exception {

        MultiValueMap<String, String> headMap = new LinkedMultiValueMap<>();
        headMap.add("key1", "val1");
        headMap.add("key2", "val2");
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(headMap);
        mvc.perform(get("/ex/foos").headers(headers)
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string("Get some Foos with Header"));
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
