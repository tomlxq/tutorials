package www.tom.com.oop.thisusage;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
@Data
//@NoArgsConstructor
public class KeywordTest {

    private String name;
    private int age;

    public KeywordTest(String name, int age) {
        this.name = name;
        this.age = age;
    }
 /*   public KeywordTest(String name, int age) {
        this();

        // the rest of the code
    }*/
    public KeywordTest() {
        this("John", 27);
        printInstance(this);
    }
    public void printInstance(KeywordTest thisKeyword) {
        System.out.println(thisKeyword);
    }

    //private String name;

    class ThisInnerClass {

        boolean isInnerClass = true;

        public ThisInnerClass() {
            KeywordTest thisKeyword = KeywordTest.this;
            String outerString = KeywordTest.this.name;
        }
    }
}