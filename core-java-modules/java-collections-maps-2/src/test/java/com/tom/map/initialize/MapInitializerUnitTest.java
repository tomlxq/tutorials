package com.tom.map.initialize;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
@Slf4j
public class MapInitializerUnitTest {

    @Test
    public void givenStaticMap_whenUpdated_thenCorrect() {

        MapInitializer.articleMapOne.put("NewArticle1", "Convert array to List");

        assertEquals(MapInitializer.articleMapOne.get("NewArticle1"), "Convert array to List");

    }

    @Test(expected=UnsupportedOperationException.class)
    public void givenSingleTonMap_whenEntriesAdded_throwsException() {

        Map<String, String> map = MapInitializer.createSingletonMap();
        map.put("username2", "password2");
    }

}