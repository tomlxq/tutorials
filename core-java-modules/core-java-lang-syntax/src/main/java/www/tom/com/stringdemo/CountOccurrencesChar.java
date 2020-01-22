package www.tom.com.stringdemo;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/20
 */
public class CountOccurrencesChar {
    public static int useRecursionToCountChars(
            String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + useRecursionToCountChars(
                someString, searchedChar, index + 1);
    }
}
