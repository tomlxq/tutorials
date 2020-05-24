package com.tom.properties.multiple;

import com.tom.properties.spring.PropertyPlaceholderConfig;
import com.tom.properties.spring.PropertySourcesPlaceholderConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig({PropertyPlaceholderConfig.class, PropertySourcesPlaceholderConfig.class})
public class MultiplePlaceholdersJavaConfigIntegrationTest {

    @Value("${key.something}")
    private String something;


    @Test
    public void whenReadInjectedValues_thenGetCorrectValues() {
        assertThat(something).isEqualTo("val");
    }
}