package www.tom.com.stringdemo;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/20
 */
@Slf4j
public class SplitString {
    /**
     * String.split()
     */
    public void strSplit(){
        String[] splitted = "peter,james,thomas".split(",");
        String[] splitted2 = "car jeep scooter".split(" ");
        String[] splitted3 = "192.168.1.178".split("\\.");
        String[] splitted4 = "b a, e, l.d u, n g".split("\\s+|,\\s*|\\.\\s*");
    }
    /**
     * StringUtils.split()
     * Apache's common lang package provides a StringUtils class – which contains a null-safe split() method, that splits using whitespace as the default delimiter:
     */
    public static void strSplit2(){
        String[] splitted = StringUtils.split("car jeep scooter");
        log.info("{}",JSON.toJSONString(splitted));
        String[] splitted1 = StringUtils.split("car   jeep  scooter");
        log.info("{}", JSON.toJSONString(splitted1));
    }
    /**
     * Splitter.split()
     */
    public static void strSplit3(){
        List<String> resultList = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .splitToList("car,jeep,, scooter");
        log.info("{}", JSON.toJSONString(resultList));
    }
    public static void strSplit4() {
        String input = " car , jeep, scooter ";
        String[] splitted = input.trim().split("\\s*,\\s*");
        log.info("{}", JSON.toJSONString(splitted));
        String[] splitted2 = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        log.info("{}", JSON.toJSONString(splitted2));

    }
}

