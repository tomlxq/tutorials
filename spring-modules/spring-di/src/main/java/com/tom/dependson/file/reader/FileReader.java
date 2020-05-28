package com.tom.dependson.file.reader;

import com.tom.dependson.shared.File;

public class FileReader {

    public FileReader(File file) {
        file.setText("read");
    }

    public void readFile() {
    }
}
