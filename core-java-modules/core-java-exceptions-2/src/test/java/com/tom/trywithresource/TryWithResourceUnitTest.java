package com.tom.trywithresource;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/7/8
 */
public class TryWithResourceUnitTest {
    @Test
    public void test_printWriter() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
            writer.println("Hello World");
        }
    }

    @Test
    public void test_scannerTryCatchFinally() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    @Test
    public void test_scannerTryWithResources() {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    @Test
    public void test_scannerTryWithMultiResources() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("test.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }
    }
}
