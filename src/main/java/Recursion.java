//рекурсивный без кеша O(3^n), потому что на каждом шаге программа расходится на три рекурсивных вызова.

import java.time.Instant;
import java.util.Arrays;

class Recursion {

    static Instant startInstant = Instant.now();

    static int computeLevenshteinDistance(String s1, String s2) {
        if (s1.isEmpty()) {
            return s2.length();
        }
        if (s2.isEmpty()) {
            return s1.length();
        }
        // вычисляем количество различных символов, которые нужно заменить в s1, путем рекурсивного обхода каждой подстроки
        int replace = computeLevenshteinDistance(s1.substring(1), s2.substring(1)) + NumOfReplacement(s1.charAt(0), s2.charAt(0));
        // количество вставок в s1 рекурсивно
        int insert = computeLevenshteinDistance(s1, s2.substring(1)) + 1;
        // количество удалений в s1 рекурсивно
        int delete = computeLevenshteinDistance(s1.substring(1), s2) + 1;
        // возвращаем минимум три операции
        return minm_edits(replace, insert, delete);
    }
    static int NumOfReplacement ( char c1, char c2){
        // проверка наличие различных символов в s1 и s2
        return c1 == c2 ? 0 : 1;
    }
    static int minm_edits ( int...nums){
        // получает количество выполненных различных операций и возвращает минимальное значение среди них.
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }
    // }
    static Instant finishInstant = Instant.now();
    static long difference = finishInstant.toEpochMilli() - startInstant.toEpochMilli();
}