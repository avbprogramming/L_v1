
// Левенштейн с памятью
import java.util.Arrays;

public class LevenshteinMemory {
  public static int computeLevenshteinDistanceDP(String s1, String s2) {
        // Двумерная матрица для хранения ранее рассчитанных ответов подзадач для получения окончательного
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // Если s1 пусто, все символы s2 вставляются в s1, что является единственно возможным методом преобразования с минимальными операциями.
                if (i == 0) {
                    dp[i][j] = j;
                }
                // Если s2 пусто, все символы s1 вставляются в s2, что является единственно возможным методом преобразования с минимальными операциями.
                else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    // находим минимум среди трех операций
                    dp[i][j] = minm_edits(dp[i - 1][j - 1] + NumOfReplacement(s1.charAt(i - 1), s2.charAt(j - 1)), // replace
                            dp[i - 1][j] + 1, // delete
                            dp[i][j - 1] + 1); // insert
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    // проверка на наличие различных символов в s1 и s2
    static int NumOfReplacement(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }
    // получает количество выполненных различных операций и возвращает минимальное значение среди них.
    static int minm_edits(int... nums) {
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }

}