
// Рекурсия с памятью
class RecursionWithMemory {
    static int minDis(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0)
            return m;
        if (m == 0)
            return n;
        // Проверка была ли уже выполнена рекурсия для n и m
        if (dp[n][m] != -1)
            return dp[n][m];
        // Проверка была ли уже выполнена рекурсия для n и m, если символы равны, выполнить рекурсивную функцию для n-1, m-1
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            if (dp[n - 1][m - 1] == -1) {
                return dp[n][m] = minDis(s1, s2, n - 1, m - 1, dp);
            } else
                return dp[n][m] = dp[n - 1][m - 1];
        }
        // Если символы не равны, ищем минимальную стоимость всех 3 операций
        else {
            int m1, m2, m3;
            if (dp[n - 1][m] != -1) {
                m1 = dp[n - 1][m];
            } else {
                m1 = minDis(s1, s2, n - 1, m, dp);
            }
            if (dp[n][m - 1] != -1) {
                m2 = dp[n][m - 1];
            } else {
                m2 = minDis(s1, s2, n, m - 1, dp);
            }

            if (dp[n - 1][m - 1] != -1) {
                m3 = dp[n - 1][m - 1];
            } else {
                m3 = minDis(s1, s2, n - 1, m - 1, dp);
            }
            return dp[n][m] = 1 + Math.min(m1, Math.min(m2, m3));
        }
    }
}