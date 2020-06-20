package com.tom;

import com.tom.boot.Application;
import com.tom.boot.config.H2JpaConfig;
import com.tom.boot.domain.GenericEntity;
import com.tom.boot.repository.GenericEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class, H2JpaConfig.class})
public class SpringBootH2IntegrationTest {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        GenericEntity genericEntity = genericEntityRepository.save(new GenericEntity("test"));
        GenericEntity foundEntity = genericEntityRepository.findById(genericEntity.getId()).orElse(null);

        assertNotNull(foundEntity);
        assertEquals(genericEntity.getValue(), foundEntity.getValue());
    }

}