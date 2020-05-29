package com.tom.streamutils;

import org.springframework.util.StreamUtils;

import java.io.InputStream;

public class DrainStream {
    public InputStream getInputStream() {
        return StreamUtils.emptyInput();
    }
}
