package com.tom.globalexceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class MalformedURL {

    private static Logger LOGGER = LoggerFactory.getLogger(MalformedURL.class);

    public static void main(String[] args) {

        URL tomURL = null;

        try {
            tomURL = new URL("malformedurl");
        } catch (MalformedURLException e) {
            LOGGER.error("MalformedURLException caught!");
        }

    }

}
