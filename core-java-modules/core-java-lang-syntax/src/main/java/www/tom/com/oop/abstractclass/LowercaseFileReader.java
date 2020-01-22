package www.tom.com.oop.abstractclass;

import java.nio.file.Path;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class LowercaseFileReader extends BaseFileReader {

    public LowercaseFileReader(Path filePath) {
        super(filePath);
    }

    @Override
    public String mapFileLine(String line) {
        return line.toLowerCase();
    }
}
