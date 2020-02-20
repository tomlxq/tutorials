package www.tom.stringconversions;
import java.time.LocalDateTime;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/23
 */
public class UseLocalDateTime {

    public LocalDateTime getLocalDateTimeUsingParseMethod(String representation) {
        return LocalDateTime.parse(representation);
    }

}
