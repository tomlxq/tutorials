package www.tom.com.oop.constructuers;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
@Slf4j
@Data
@NoArgsConstructor
public class User implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private static final int YEAR = 2000;
    private String name;
    private int id;
    public User(String name, int id) {
        log.info("constructors");
        this.name = name;
        this.id = id;
    }
    /**
     * Instance Initializers
     */
    {
        id = 0;
        System.out.println("instance variables and instance initializers in order");
    }
    /**
     * Static Initialization Block
     */
    private static String forum;
    static {
        log.info("static variables and static initializers in order");
        forum = "Java";
    }
    // standard constructor, getters, setters,
}
