package com.tom;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/15
 */
public class CreateNavMenu {
    @Test
    public void name() throws IOException {
        String dic = "E:\\data\\wwwtest\\tutorials\\";
        //E:\data\wwwtest\tutorials\doc\1.Exception Handling in Java.md
        final Collection<File> files = FileUtils.listFiles(new File(dic), new String[]{"md"}, true);

        final Map<String, String> collect = files.stream()
                .collect(
                        Collectors.toMap(line -> line.getName().replace(".md", ""),
                                line -> line.getPath().replace(dic, ""), (exist, newEntry) -> exist));
        FileUtils.writeLines(new File(dic + "README.md"), StandardCharsets.UTF_8.name(), collect.values());
    }
}
