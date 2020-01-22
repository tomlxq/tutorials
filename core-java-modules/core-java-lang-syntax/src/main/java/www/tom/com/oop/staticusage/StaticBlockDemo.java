package www.tom.com.oop.staticusage;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class StaticBlockDemo {
    public static List<String> ranks = new LinkedList<>();

    static {
        ranks.add("Lieutenant");
        ranks.add("Captain");
        ranks.add("Major");
    }

    static {
        ranks.add("Colonel");
        ranks.add("General");
    }
}