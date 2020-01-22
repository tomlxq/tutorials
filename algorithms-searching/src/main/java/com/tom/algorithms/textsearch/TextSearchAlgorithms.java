package com.tom.algorithms.textsearch;

import java.math.BigInteger;
import java.util.Random;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
public class TextSearchAlgorithms {
    public static long getBiggerPrime(int m) {
        BigInteger prime = BigInteger.probablePrime(getNumberOfBits(m) + 1, new Random());
        return prime.longValue();
    }
    private static int getNumberOfBits(int number) {
        return Integer.SIZE - Integer.numberOfLeadingZeros(number);
    }

    /**
     * Simple Text Search
     * The idea of this algorithm is straightforward: iterate through the text and if there is a match for the first letter of the pattern, check if all the letters of the pattern match the text.
     *
     * If m is a number of the letters in the pattern, and n is the number of the letters in the text, time complexity of this algorithms is O(m(n-m + 1)).
     * @param pattern
     * @param text
     * @return
     */
    public static int simpleTextSearch(char[] pattern, char[] text) {
        int patternSize = pattern.length;
        int textSize = text.length;

        int i = 0;

        while ((i + patternSize) <= textSize) {
            int j = 0;
            while (text[i + j] == pattern[j]) {
                j += 1;
                if (j >= patternSize) {
                    return i;
                }
            }
            i += 1;
        }
        return -1;
    }

    /**
     * Rabin Karp Algorithm
     * As mentioned above, Simple Text Search algorithm is very inefficient when patterns are long and when there is a lot of repeated elements of the pattern.
     *
     * The idea of Rabin Karp algorithm is to use hashing to find a pattern in a text. At the beginning of the algorithm, we need to calculate a hash of the pattern which is later used in the algorithm. This process is called fingerprint calculation, and we can find a detailed explanation here.
     *
     * The important thing about pre-processing step is that its time complexity is O(m) and iteration through text will take O(n) which gives time complexity of whole algorithm O(m+n).
     * @param pattern
     * @param text
     * @return
     */
    public static int rabinKarpMethod(char[] pattern, char[] text) {
        int patternSize = pattern.length;
        int textSize = text.length;

        long prime = getBiggerPrime(patternSize);

        long r = 1;
        for (int i = 0; i < patternSize - 1; i++) {
            r *= 2;
            r = r % prime;
        }

        long[] t = new long[textSize];
        t[0] = 0;

        long pfinger = 0;

        for (int j = 0; j < patternSize; j++) {
            t[0] = (2 * t[0] + text[j]) % prime;
            pfinger = (2 * pfinger + pattern[j]) % prime;
        }

        int i = 0;
        boolean passed = false;

        int diff = textSize - patternSize;
        for (i = 0; i <= diff; i++) {
            if (t[i] == pfinger) {
                passed = true;
                for (int k = 0; k < patternSize; k++) {
                    if (text[i + k] != pattern[k]) {
                        passed = false;
                        break;
                    }
                }

                if (passed) {
                    return i;
                }
            }

            if (i < diff) {
                long value = 2 * (t[i] - r * text[i]) + text[i + patternSize];
                t[i + 1] = ((value % prime) + prime) % prime;
            }
        }
        return -1;

    }
    /**
     * Knuth-Morris-Pratt Algorithm
     * The idea of the Knuth-Morris-Pratt algorithm is the calculation of shift table which provides us with the information where we should search for our pattern candidates.
     */
    public static int knuthMorrisPrattSearch(char[] pattern, char[] text) {
        int patternSize = pattern.length;
        int textSize = text.length;

        int i = 0, j = 0;

        int[] shift = KnuthMorrisPrattShift(pattern);

        while ((i + patternSize) <= textSize) {
            while (text[i + j] == pattern[j]) {
                j += 1;
                if (j >= patternSize) {
                    return i;
                }
            }

            if (j > 0) {
                i += shift[j - 1];
                j = Math.max(j - shift[j - 1], 0);
            } else {
                i++;
                j = 0;
            }
        }
        return -1;
    }public static int[] KnuthMorrisPrattShift(char[] pattern) {
        int patternSize = pattern.length;

        int[] shift = new int[patternSize];
        shift[0] = 1;

        int i = 1, j = 0;

        while ((i + j) < patternSize) {
            if (pattern[i + j] == pattern[j]) {
                shift[i + j] = i;
                j++;
            } else {
                if (j == 0) {
                    shift[i] = i + 1;
                }

                if (j > 0) {
                    i = i + shift[j - 1];
                    j = Math.max(j - shift[j - 1], 0);
                } else {
                    i = i + 1;
                    j = 0;
                }
            }
        }
        return shift;
    }

    /**
     * Simple Boyer-Moore Algorithm
     * Two scientists, Boyer and Moore, came up with another idea.
     * Why not compare the pattern to the text from right to left instead of left to right, while keeping the shift direction the same
     * @param pattern
     * @param text
     * @return
     */
    public static int boyerMooreHorspoolSimpleSearch(char[] pattern, char[] text) {
        int patternSize = pattern.length;
        int textSize = text.length;

        int i = 0, j = 0;

        while ((i + patternSize) <= textSize) {
            j = patternSize - 1;
            while (text[i + j] == pattern[j]) {
                j--;
                if (j < 0)
                    return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * Boyer-Moore-Horspool Algorithm
     * This version of the algorithm is called Boyer-Moore-Horspool, and this variation solved the problem of negative shifts (we can read about negative shift problem in the description of the Boyer-Moore algorithm).
     * @param pattern
     * @param text
     * @return
     */
    public static int boyerMooreHorspoolSearch(char[] pattern, char[] text) {

        int shift[] = new int[256];

        for (int k = 0; k < 256; k++) {
            shift[k] = pattern.length;
        }

        for (int k = 0; k < pattern.length - 1; k++){
            shift[pattern[k]] = pattern.length - 1 - k;
        }

        int i = 0, j = 0;

        while ((i + pattern.length) <= text.length) {
            j = pattern.length - 1;

            while (text[i + j] == pattern[j]) {
                j -= 1;
                if (j < 0)
                    return i;
            }

            i = i + shift[text[i + pattern.length - 1]];
        }
        return -1;
    }

}
