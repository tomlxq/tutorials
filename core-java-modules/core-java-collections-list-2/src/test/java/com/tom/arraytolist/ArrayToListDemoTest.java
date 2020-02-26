package com.tom.arraytolist;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
@Slf4j
public class ArrayToListDemoTest {

    @Test
    public void test_aslist() {
        List<String> flowers = Arrays.asList("Ageratum", "Allium", "Poppy", "Catmint");
    }

    @Test
    public void test_pass_actual_array() {
        String[] flowers = {"Ageratum", "Allium", "Poppy", "Catmint"};
        List<String> flowerList = Arrays.asList(flowers);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_add_unsupportedOperationException() {
        String[] flowers = {"Ageratum", "Allium", "Poppy", "Catmint"};
        List<String> flowerList = Arrays.asList(flowers);
        flowerList.add("Celosia");
    }
    @Test(expected = UnsupportedOperationException.class)
    public void test_remove_unsupportedOperationException() {
        String[] flowers = {"Ageratum", "Allium", "Poppy", "Catmint"};
        List<String> flowerList = Arrays.asList(flowers);
        flowerList.remove("Ageratum");
    }
    @Test
    public void test_add_withNewArrayList() {
        String[] flowers = {"Ageratum", "Allium", "Poppy", "Catmint"};
        List<String> flowerList = new ArrayList<>(Arrays.asList(flowers));
        flowerList.add("Celosia");
        flowerList.remove("Ageratum");
        log.info("{}", JSON.toJSONString(flowerList));
    }
}