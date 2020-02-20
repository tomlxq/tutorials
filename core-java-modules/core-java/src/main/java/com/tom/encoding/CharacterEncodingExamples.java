package com.tom.encoding;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
public class CharacterEncodingExamples {
   public static String decodeText(String input, String encoding) throws IOException {
        return
                new BufferedReader(
                        new InputStreamReader(
                                new ByteArrayInputStream(input.getBytes()),
                                Charset.forName(encoding)))
                        .readLine();
    }

    public static String convertToBinary(String input, String encoding)
            throws UnsupportedEncodingException {
        byte[] encoded_input = Charset.forName(encoding)
                .encode(input)
                .array();
        return IntStream.range(0, encoded_input.length)
                .map(i -> encoded_input[i])
                .mapToObj(e -> Integer.toBinaryString(e ^ 255))
                .map(e -> String.format("%1$" + Byte.SIZE + "s", e).replace(" ", "0"))
                .collect(Collectors.joining(" "));
    }

    /**
     * There are three predefined strategies (or CodingErrorAction) when the input sequence has malformed input:
     *
     * IGNORE will ignore malformed characters and resume coding operation
     * REPLACE will replace the malformed characters in the output buffer and resume the coding operation
     * REPORT will throw a MalformedInputException
     * @param input
     * @param charset
     * @param codingErrorAction
     * @return
     * @throws IOException
     */
    public static String decodeText(String input, Charset charset,
                      CodingErrorAction codingErrorAction) throws IOException {
        CharsetDecoder charsetDecoder = charset.newDecoder();
        charsetDecoder.onMalformedInput(codingErrorAction);
        return new BufferedReader(
                new InputStreamReader(
                        new ByteArrayInputStream(input.getBytes()), charsetDecoder)).readLine();
    }
}
