package com.tom.newline;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
@Slf4j
public class AddingNewLineToString {
    static String line1 = "Humpty Dumpty sat on a wall.";
    static String line2 = "Humpty Dumpty had a great fall.";

    /**
     * For a Unix/Linux/New Mac-based OS we can use “\n”:
     */
    public static void add4Linux() {

        String rhyme = line1 + "\n" + line2;
        log.info(rhyme);
    }

    /**
     * If we are on a Windows based OS, we can use “\r\n”:
     */


    public static void add4Win() {
        String rhyme = line1 + "\r\n" + line2;
        log.info(rhyme);
    }

    /**
     * For an Old Mac based OS, we can use “\r”:
     */

    public static void add4OldMacOS() {
        String rhyme = line1 + "\r" + line2;
        log.info(rhyme);
    }

    /**
     * Using Platform-Independent Line Breaks
     */
    public static void add4PlatformIndependent() {
        String rhyme = line1 + System.lineSeparator() + line2;
        log.info(rhyme);

        rhyme = line1 + System.getProperty("line.separator") + line2;
        log.info(rhyme);
    }

    /**
     * HTML Break Tag
     */
    public static void add4HtmlTab() {
        String rhyme = line1 + "<br>" + line2;
        log.info(rhyme);
    }

    /**
     * New Line Character
     * We can use ‘\n' to break a line, if text is enclosed in <pre> or <textarea> tag:
     */
    public static void add4PreOrTextarea() {
        String rhyme = line1 + "<br>" + line2;
        log.info(rhyme);
    }

    /**
     * Unicode Characters
     * We can use Unicode characters “& #13;” (Carriage Return) and “& #10;” (Line Feed), to break a line. For example, in the <textarea> tag
     */
    public static void add4PreOrTextareaUnicode() {
        String rhyme = line1 + "&#13;" + line2;
        log.info(rhyme);
        rhyme = line1 + "&#13;" + line2;
        log.info(rhyme);
        rhyme = line1 + "&#10;" + line2;
        log.info(rhyme);
        rhyme = line1 + "&#10;" + line2;
        log.info(rhyme);
    }
}
