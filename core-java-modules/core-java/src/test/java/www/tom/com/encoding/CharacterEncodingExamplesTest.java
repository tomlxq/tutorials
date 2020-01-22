package www.tom.com.encoding;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static www.tom.com.encoding.CharacterEncodingExamples.convertToBinary;
import static www.tom.com.encoding.CharacterEncodingExamples.decodeText;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
@Slf4j
class CharacterEncodingExamplesTest {

    @Test
    void decodeTextTest() throws IOException {
        log.info("{}", decodeText("The façade pattern is a software design pattern.", "US-ASCII"));
        log.info("{}", decodeText("The façade pattern is a software design pattern.", "UTF-8"));


    }

    @Test
    void convertToBinaryTest() throws UnsupportedEncodingException {
        assertEquals(convertToBinary("T", "US-ASCII"), "10101011");

        assertEquals(convertToBinary("語", "Big5"), "11111111111111111111111101000100 10000110");

        assertEquals(convertToBinary("T", "UTF-32"), "11111111 11111111 11111111 10101011");

        assertEquals(convertToBinary("T", "UTF-8"), "10101011");

        assertEquals(convertToBinary("語", "UTF-8"), "11111111111111111111111100010111 11111111111111111111111101010101 11111111111111111111111101100001");
    }
    @Test
    void showDefaultCharset()  {
        log.info("{}",   Charset.defaultCharset().displayName());

    }

    /**
     * Many of the Java APIs make use of the default charset as determined by the JVM. To name a few:
     *
     * InputStreamReader and FileReader
     * OutputStreamWriter and FileWriter
     * Formatter and Scanner
     * URLEncoder and URLDecoder
     * @throws IOException
     */
    @Test
    void whoUsesDefaultCharsetTest() throws IOException {
        String input="我们是中国人";
        log.info("{}", new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()))).readLine());
    }

    @Test
    void malformedInputExceptionTest() throws IOException {

        Assertions.assertEquals(
                "The faade pattern is a software design pattern.",
                decodeText(
                        "The façade pattern is a software design pattern.",
                        StandardCharsets.US_ASCII,
                        CodingErrorAction.IGNORE));

        Assertions.assertEquals(
                "The fa��ade pattern is a software design pattern.",
                CharacterEncodingExamples.decodeText(
                        "The façade pattern is a software design pattern.",
                        StandardCharsets.US_ASCII,
                        CodingErrorAction.REPLACE));

        Assertions.assertThrows(
                MalformedInputException.class,
                () -> CharacterEncodingExamples.decodeText(
                        "The façade pattern is a software design pattern.",
                        StandardCharsets.US_ASCII,
                        CodingErrorAction.REPORT));
    }
}