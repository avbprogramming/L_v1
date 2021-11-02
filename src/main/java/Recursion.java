// Java implementation of recursive Levenshtein distance

import java.time.Instant;
import java.util.Arrays;

class Recursion { //рекурсивный без кеша O(3^n), потому что на каждом шаге программа расходится на три рекурсивных вызова.

    static Instant startInstant = Instant.now();

    static int computeLevenshteinDistance(String s1, String s2) {
        //  for (int i = 0; i < 10; i++) {
        if (s1.isEmpty()) {
            return s2.length();
        }
        if (s2.isEmpty()) {
            return s1.length();
        }
        // calculate the number of distinct characters to be replaced in s1 by recursively traversing each substring
        int replace = computeLevenshteinDistance(s1.substring(1), s2.substring(1)) + NumOfReplacement(s1.charAt(0), s2.charAt(0));
        // calculate the number of insertions in s1 recursively
        int insert = computeLevenshteinDistance(s1, s2.substring(1)) + 1;
        // calculate the number of deletions in s1 recursively
        int delete = computeLevenshteinDistance(s1.substring(1), s2) + 1;
        // returns minimum of three operatoins
        return minm_edits(replace, insert, delete);
    }
    static int NumOfReplacement ( char c1, char c2){
        // check for distinct characters in s1 and s2
        return c1 == c2 ? 0 : 1;
    }
    static int minm_edits ( int...nums){
        // receives the count of different operations performed and returns the minimum value among them.
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }
    // }
    static Instant finishInstant = Instant.now();
    static long difference = finishInstant.toEpochMilli() - startInstant.toEpochMilli();
}