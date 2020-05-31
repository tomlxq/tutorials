package com.tom.resource;

import com.tom.configuration.ApplicationContextTestResourceNameType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = ApplicationContextTestResourceNameType.class)
public class FieldResourceInjectionIntegrationTest {

    @Resource(name = "namedFile")
    private File defaultFile;

    @Resource
    private File defaultFileMatchByType;

    @Test
    public void givenResourceAnnotation_WhenOnField_ThenDependencyValid() {
        assertNotNull(defaultFile);
        assertEquals("namedFile.txt", defaultFile.getName());
    }

    @Test
    public void givenResourceAnnotation_WhenOnField_ThenDependencyMatchByType() {
        assertNotNull(defaultFileMatchByType);
        assertEquals("namedFile.txt", defaultFileMatchByType.getName());
    }
}
