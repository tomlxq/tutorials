package com.tom.algorithms.textsearch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static com.tom.algorithms.textsearch.TextSearchAlgorithms.simpleTextSearch;
import static org.junit.jupiter.api.Assertions.*;
import static com.tom.algorithms.textsearch.TextSearchAlgorithms.boyerMooreHorspoolSearch;
import static com.tom.algorithms.textsearch.TextSearchAlgorithms.boyerMooreHorspoolSimpleSearch;
import static com.tom.algorithms.textsearch.TextSearchAlgorithms.knuthMorrisPrattSearch;
import static com.tom.algorithms.textsearch.TextSearchAlgorithms.rabinKarpMethod;
import static com.tom.algorithms.textsearch.TextSearchAlgorithms.simpleTextSearch;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
@Slf4j
class TextSearchAlgorithmsTest {

    @Test
    void simpleTextSearchTest() {
     log.info("{}",simpleTextSearch("pizza".toCharArray(),"I love pizza".toCharArray()));
    }

    @Test
    void rabinKarpMethodTest() {
        log.info("{}",rabinKarpMethod("pizza".toCharArray(),"I love pizza".toCharArray()));
    }

    @Test
    void knuthMorrisPrattShiftTest() {
        log.info("{}",knuthMorrisPrattSearch("pizza".toCharArray(),"I love pizza".toCharArray()));
    }

    @Test
    void boyerMooreHorspoolSearchTest() {
        log.info("{}",boyerMooreHorspoolSearch("pizza".toCharArray(),"I love pizza".toCharArray()));
    }

    @Test
    void boyerMooreHorspoolSimpleSearchTest() {
        log.info("{}",boyerMooreHorspoolSimpleSearch("pizza".toCharArray(),"I love pizza".toCharArray()));
    }
}