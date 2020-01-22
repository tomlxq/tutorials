package www.tom.com.stringdemo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
@Slf4j
public class StringUsageTest {

    @Test
    public void loadFromFile() throws IOException {
         StringUsage stringUsage = new StringUsage();
        log.info("{}", stringUsage.loadFromFile());
    }
}