import org.junit.Test;
import www.tom.com.oop.abstractclass.BaseFileReader;
import www.tom.com.oop.abstractclass.LowercaseFileReader;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class BaseFileReaderTest {
    @Test
    public void givenLowercaseFileReaderInstance_whenCalledreadFile_thenCorrect() throws Exception {

        URL location = getClass().getClassLoader().getResource("files/test.txt");
        Path path = Paths.get(location.toURI());
        //FileUtils.writeLines(path.toFile(), StandardCharsets.UTF_8.name(), Arrays.asList("hell","world"));
        BaseFileReader lowercaseFileReader = new LowercaseFileReader(path);

        assertThat(lowercaseFileReader.readFile()).isInstanceOf(List.class);

    }
}
