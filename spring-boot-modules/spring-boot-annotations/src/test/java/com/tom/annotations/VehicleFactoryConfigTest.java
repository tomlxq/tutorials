package com.tom.annotations;

import com.tom.config.VehicleFactoryConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {VehicleFactoryConfig.class}, loader = AnnotationConfigContextLoader.class)
@Slf4j
public class VehicleFactoryConfigTest {
    @Autowired
    Engine engine;

    @Test
    public void test() {
        Assert.assertTrue(engine != null);
    }

    @Autowired
    Bike bike;

    @Test
    public void testBike() {
        Assert.assertTrue(bike != null);
    }
}