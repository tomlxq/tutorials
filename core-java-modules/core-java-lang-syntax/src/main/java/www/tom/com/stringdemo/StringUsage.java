package www.tom.com.stringdemo;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class StringUsage {
    /**
     * Getting the Line Separator
     */
    String newLine = System.getProperty("line.separator");
    /**
     * String Concatenation
     * @return
     */
    public String stringConcatenation2() {
        return "Get busy living"
                + newLine
                + "or"
                + newLine
                + "get busy dying."
                + newLine
                + "--Stephen King";
    }
    public String stringConcatenation() {
        return "Get busy living"
                .concat(newLine)
                .concat("or")
                .concat(newLine)
                .concat("get busy dying.")
                .concat(newLine)
                .concat("--Stephen King");
    }
    /**
     * String Join
     * @return
     */
    public String stringJoin() {
        return String.join(newLine,
                "Get busy living",
                "or",
                "get busy dying.",
                "--Stephen King");
    }




    /**
     * String Builder
     * @return
     */
    public String stringBuilder() {
        return new StringBuilder()
                .append("Get busy living")
                .append(newLine)
                .append("or")
                .append(newLine)
                .append("get busy dying.")
                .append(newLine)
                .append("--Stephen King")
                .toString();
    }

    /**
     * String Writer
     * @return
     */
    public String stringWriter() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println("Get busy living");
        printWriter.println("or");
        printWriter.println("get busy dying.");
        printWriter.println("--Stephen King");
        return stringWriter.toString();
    }

    /**
     * Guava Joiner
     * @return
     */
    public String guavaJoiner() {
        return Joiner.on(newLine).join(ImmutableList.of("Get busy living",
                "or",
                "get busy dying.",
                "--Stephen King"));
    }
    public String loadFromFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/resources/files/stephenking.txt")));
    }
}
