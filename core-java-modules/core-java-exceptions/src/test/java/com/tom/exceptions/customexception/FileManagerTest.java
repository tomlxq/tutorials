package com.tom.exceptions.customexception;



import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
public class FileManagerTest {

    @Test(expected = IncorrectFileNameException.class)
   public void getFirstLine() throws IncorrectFileNameException {
        FileManager.getFirstLine("wrongFileName.txt");
    }

    @Test(expected = IncorrectFileExtensionException.class)
    public void getFirstLine2() throws IncorrectFileNameException{
        FileManager.getFirstLine("wrongFileName.csv");
    }
}