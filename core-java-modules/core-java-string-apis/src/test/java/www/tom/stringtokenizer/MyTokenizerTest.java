package www.tom.stringtokenizer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/22
 */
@Slf4j
public class MyTokenizerTest {
    private MyTokenizer myTokenizer = null;

    @BeforeEach
    void setUp() {
        myTokenizer = new MyTokenizer();
    }

    @Test
    void getTokensTest() {

        log.info("{}", myTokenizer.getTokens("Welcome,to,blue.com"));
    }

    private List<String> expectedTokensForString = Arrays.asList(
            "Welcome", "to", "blue.com");
    private List<String> expectedTokensForFile = Arrays.asList(
            "1", "IND", "India",
            "2", "MY", "Malaysia",
            "3", "AU", "Australia");

    @Test
    public void givenString_thenGetListOfString() {
        String str = "Welcome,to,blue.com";
        List<String> actualTokens = myTokenizer.getTokens(str);

        assertEquals(expectedTokensForString, actualTokens);
    }

    @Test
    public void givenFile_thenGetListOfString() {
        List<String> actualTokens = myTokenizer.getTokensFromFile(
                "data.csv", "|");

        assertEquals(expectedTokensForFile, actualTokens);
    }

    @Test
    void getTokensWithCollectionTest() {
        log.info("{}", myTokenizer.getTokensWithCollection("Welcome,to,blue.com"));
    }

    @Test
    void getTokensWithCollectionTest2() {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer("Welcome,to,blue.com", ",");
        int tokenLength = tokens.size();
        log.info("tokenLength {}", tokenLength);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken("e"));
        }
        log.info("{}", JSON.toJSONString(tokens));
    }
}