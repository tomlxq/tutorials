package www.tom.com.stringdemo;

import java.util.Optional;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class RemoveLastCharacter {
    /**
     * Using String.substring()
     *
     * @param s
     * @return
     */
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }

    public static String removeLastCharOptional(String s) {
        return Optional.ofNullable(s)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 1))
                .orElse(s);
    }

    public static void main(String[] args) {
        System.out.println(removeLastCharOptional(""));
        System.out.println(removeLastCharOptional(null));
        System.out.println(removeLastCharOptional("hello,world"));
        System.out.println(removeLastChar2());
    }

    /**
     *  Using StringUtils.substring()
     * @param s
     * @return
     */
    public static String removeLastChar1() {
        String TEST_STRING = "abcdef";

        return org.apache.commons.lang3.StringUtils.substring(TEST_STRING, 0, TEST_STRING.length() - 1);
    }
    public static String removeLastChar2() {
        String TEST_STRING = "abcdef";

        return org.apache.commons.lang3.StringUtils.chop(TEST_STRING);
    }
    /**
     * Using Regular Expression
     */
    public static String removeLastChar3() {
        String TEST_STRING = "abcdef";

        return TEST_STRING.replaceAll(".$", "");
    }
    public static String removeLastCharRegex(String s) {
        return (s == null) ? null : s.replaceAll(".$", "");
    }
}
