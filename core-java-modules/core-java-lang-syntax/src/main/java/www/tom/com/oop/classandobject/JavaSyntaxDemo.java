package www.tom.com.oop.classandobject;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
@Slf4j
public class JavaSyntaxDemo {
    public static void main(String[] args) {
    /*    shortSyntax();
        longSyntax();
        floatSyntax();
        doubleSyntax();
        booleanSyntax();
        charSyntax();*/
        overflow();
        autoboxing();
    }

    private static void autoboxing() {
        Character c = 'c';

        Integer i = 1;
        log.info("Character {}",c);
        log.info("Integer {}",i);
    }

    private static void shortSyntax() {
        short s = 202;
    }

    private static void longSyntax() {
        long l = 1234567890;
    }

    private static void floatSyntax() {
        float f = 3.145f;
    }

    private static void doubleSyntax() {
        double d = 3.13457599923384753929348D;
    }

    private static void booleanSyntax() {
        boolean b = true;
        boolean b1=false;
        log.info("布尔型,给定初始值 {}",b);
        log.info("布尔型,未给初始值 {}",b1);
    }

    private static void charSyntax() {
        char c = 'a';

        char c1 = 65;

        char c2=0;
        log.info("char型,给定初始值 {}",c1);
        log.info("char型,给定初始值 {}",c2);
    }

    private static void overflow() {
        int i = Integer.MAX_VALUE;
        int j = i + 1;
// j will roll over to -2_147_483_648
        log.info("int overflow {}",j);
        log.info("int underflow {}",Integer.MIN_VALUE-1);
        double d = Double.MAX_VALUE;
        double o = d + 1;
// o will be Infinity
        log.info("double overflow {}",o);
        log.info("double overflow {}",Double.MIN_VALUE-1);
    }


}
