package com.tom.dependson.file.processor;

import com.tom.dependson.shared.File;

public class FileProcessor {

    File file;

    public FileProcessor(File file) {
        this.file = file;
        if (file.getText().contains("write") && file.getText().contains("read")) {
            file.setText("processed");
        }
    }
}