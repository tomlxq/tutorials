package com.tom;

import com.tom.produceimage.ImageApplication;
import com.tom.responseheaders.ResponseHeadersApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ImageApplication.class,
        ResponseHeadersApplication.class,
        com.tom.web.upload.app.UploadApplication.class,
})
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
