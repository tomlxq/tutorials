package com.tom.exceptions.checkorunchec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Checked Exceptions
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class CheckedExceptions {
    private static void checkedExceptionWithThrows() throws FileNotFoundException {
        File file = new File("not_existing_file.txt");
        FileInputStream stream = new FileInputStream(file);
    }
    private static void checkedExceptionWithTryCatch() {
        File file = new File("not_existing_file.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
