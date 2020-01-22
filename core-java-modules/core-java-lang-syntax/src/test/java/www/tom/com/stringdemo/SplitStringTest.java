package www.tom.com.stringdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static www.tom.com.stringdemo.SplitString.strSplit2;
import static www.tom.com.stringdemo.SplitString.strSplit3;
import static www.tom.com.stringdemo.SplitString.strSplit4;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/20
 */
public class SplitStringTest {

    @Test
    void strSplit2Test() {
        strSplit2();
    }
    @Test
    void strSplit3Test() {
        strSplit3();
    }
    @Test
    void strSplit4Test() {
        strSplit4();
    }
}