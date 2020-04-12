package com.guava.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/6
 */
@Controller
public class ImageController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "/image-manual-response", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response) throws IOException {
        final InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping(value = "/image-byte-array", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getImageAsByteArray() throws IOException {
        final InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
        return IOUtils.toByteArray(in);
    }

    @RequestMapping(value = "/image-response-entity", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageAsResponseEntity() throws IOException {
        ResponseEntity<byte[]> responseEntity;
        final HttpHeaders headers = new HttpHeaders();
        final InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
        byte[] media = IOUtils.toByteArray(in);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/image-resource1", method = RequestMethod.GET)
    public Resource getImageAsResource1() {
        return new ServletContextResource(servletContext, "/WEB-INF/images/image-example.jpg");
    }

    @RequestMapping(value = "/image-resource", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource> getImageAsResource() {
        final HttpHeaders headers = new HttpHeaders();
        Resource resource = new ServletContextResource(servletContext, "/WEB-INF/images/image-example.jpg");
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}