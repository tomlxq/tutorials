package com.tom.requestresponsebody;

import com.alibaba.fastjson.JSON;
import com.tom.services.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
@Slf4j
public class ExamplePostController {
    @Autowired
    ExampleService exampleService;

    @PostMapping("/request")
    public ResponseEntity postController(@RequestBody LoginForm loginForm) {
        log.info("POST received - serializing LoginForm: {} {}", loginForm.getPassword(), loginForm.getUsername());
        exampleService.fakeAuthenticate(loginForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/response")
    @ResponseBody
    public ResponseTransfer postResponseController(@RequestBody LoginForm loginForm) {
        log.debug("POST received - serializing LoginForm: " + loginForm.getPassword() + " " + loginForm.getUsername());
        return new ResponseTransfer("Thanks For Posting!!!");
    }

    @PostMapping(value = "/contentJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseJsonContent(@RequestBody LoginForm loginForm) {
        log.debug("POST received - serializing LoginForm: " + loginForm.getPassword() + " " + loginForm.getUsername());
        return new ResponseTransfer("JSON Content!");
    }

    @PostMapping(value = "/contentXml", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseXmlContent(@RequestBody LoginForm loginForm) {
        log.info("POST received - serializing LoginForm: " + JSON.toJSONString(loginForm));
        return new ResponseTransfer("XML Content!");
    }
}