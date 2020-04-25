package com.tom;

import io.vavr.collection.Array;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/15
 */
@Slf4j
public class CreateNavMenuUnitTest {
    String baseDir = "";

    @Before
    public void setUp() throws Exception {
        String path = new File(this.getClass().getClassLoader().getResource("." + File.separator).toURI()).getPath();
        baseDir = StringUtils.substringBefore(path, "core-java-modules") + "doc" + File.separator;
    }

    @Test
    public void createMenu() throws IOException {
        final List<String> back_to_basics = List.of("Security with Spring", "The Registration Series");
        String filename = "4.注册–通过电子邮件激活新帐户";
        initFile(back_to_basics, filename);
    }

    private void initFile(List<String> back_to_basics, String title) throws IOException {
        String tempDir = StringUtils.join(back_to_basics, File.separator);
        final Array<String> replaceAry = Array.of(" ", "-");
        final Array<String> replaceAfter = Array.of("_", "_");
        final String baseDirName = StringUtils.replaceEachRepeatedly(StringUtils.lowerCase(tempDir), replaceAry.toJavaArray(String.class), replaceAfter.toJavaArray(String.class));
        String lastPath = baseDir + baseDirName + File.separator + title + ".md";
        log.info("{} 文件路径：{} {} 标题名：{}", System.lineSeparator(), lastPath, System.lineSeparator(), title);
        FileUtils.write(new File(lastPath), "# " + StringUtils.substringAfter(title, "."), StandardCharsets.UTF_8);
    }

    @Test
    public void test() throws ClassNotFoundException {
        //javax.annotation.Resource
        Class.forName("javax.annotation.Resource");
    }
}
