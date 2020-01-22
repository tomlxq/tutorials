package www.tom.com.oop.basic;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
@Slf4j
public class JavaControlStructuresDemo {
    public static void main(String[] args) {
//        ifElseDemo();
//        ternaryDemo();
//        switchDemo();
//        loopsDemo();
        breakDemo();
        continueDemo();
    }

    private static void continueDemo() {
        List<String> names = getNameList();
        String name = "John Doe";
        String list = "";
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name)) {
                continue;
            }
            list += names.get(i);
        }
        log.info("{}", JSON.toJSONString(list));
    }

    private static void breakDemo() {
        List<String> names = getNameList();
        String name = "John Doe";
        int index = 0;
        for ( ; index < names.size(); index++) {
            if (names.get(index).equals(name)) {
                log.info("this list has this guy {}",name);
                break;
            }
        }
    }

    private static List<String> getNameList() {
        return Arrays.asList("tom","jack","John Doe");
    }

    private static void ifElseDemo() {
        int count = 3;
        if (count > 2) {
            System.out.println("Count is higher than 2");
        } else {
            System.out.println("Count is lower or equal than 2");
        }
    }

    private static void loopsDemo() {
        for (int i = 1; i <= 50; i++) {
            methodToRepeat();
        }

        int whileCounter = 1;
        while (whileCounter <= 50) {
            methodToRepeat();
            whileCounter++;
        }
    }

    private static void methodToRepeat() {
        log.info("I am tom,Current thread  {}", Thread.currentThread().getName());
    }

    private static void switchDemo() {
        int count = 3;
        switch (count) {
            case 0:
                System.out.println("Count is equal to 0");
                break;
            case 1:
                System.out.println("Count is equal to 1");
                break;
            default:
                System.out.println("Count is either negative, or higher than 1");
                break;
        }
    }

    private static void ternaryDemo() {
        int count = 1;
        System.out.println(count > 2 ? "Count is higher than 2" : "Count is lower or equal than 2");
    }
}
