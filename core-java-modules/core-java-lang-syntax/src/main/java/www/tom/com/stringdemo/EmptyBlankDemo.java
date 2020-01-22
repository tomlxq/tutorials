package www.tom.com.stringdemo;


import com.google.common.base.Strings;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class EmptyBlankDemo {
    /**
     * With Java 6 and Above
     * @param string
     * @return
     */
    boolean isEmptyString(String string) {
        return string.isEmpty();
    }

    /**
     * To make it also null-safe, we need to add an extra check:
     * @param string
     * @return
     */
    boolean isEmptyString2(String string) {
        return string == null || string.isEmpty();
    }

    /**
     * With Java 5 and Below
     * @param string
     * @return
     */
    boolean isEmptyString3(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * Blank Strings
     * @param string
     * @return
     */
    boolean isBlankString(String string) {
        return string == null || string.trim().isEmpty();
    }

    /**
     * With Apache Commons
     * @param string
     * @return
     */
    boolean isBlankString2(String string) {
    return     org.apache.commons.lang3.StringUtils.isBlank(string);
    }

    /**
     * With Guava
     * It checks whether a given string is null or empty, but it will not check for whitespace-only strings.
     * @param string
     * @return
     */
    boolean isBlankString3(String string) {
        return   Strings.isNullOrEmpty(string);
    }


}
