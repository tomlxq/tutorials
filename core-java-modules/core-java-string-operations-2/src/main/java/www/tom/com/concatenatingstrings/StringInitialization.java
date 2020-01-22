package www.tom.com.concatenatingstrings;

/**
 * member variables are initialized with a default value when the class is constructed, null in String‘s case.
 * But, we have to initialize local variables ourselves.
 *
 * @author TomLuo
 * @date 2020/1/21
 */
public class StringInitialization {

    String fieldString;

    void printDeclaredOnlyString() {
        String localVarString;

        // System.out.println(localVarString); -> compilation error
        System.out.println(fieldString);
    }
}