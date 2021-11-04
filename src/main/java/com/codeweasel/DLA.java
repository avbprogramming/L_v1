/*

транспозиция (перестановка) двух соседних букв также учитывается как одна операция, наряду со вставками, удалениями и заменами.
Модифицировать алгоритм нахождения обычного расстояния Левенштейна следующим образом:
хранить не две, а три последних строки матрицы,
а также добавить соответствующее дополнительное условие —
в случае обнаружения транспозиции при расчете расстояния также учитывать и её стоимость.

 */


import java.util.Arrays;

public class DLA {
    public static int damerauLevenshteinDistance(String s1, String s2, int alphabetLength) {
        final int INFINITY = s1.length() + s2.length();
        int[][] H = new int[s1.length()+2][s2.length()+2];
        H[0][0] = INFINITY;
        for(int i = 0; i<=s1.length(); i++) {
            H[i+1][1] = i;
            H[i+1][0] = INFINITY;
        }
        for(int j = 0; j<=s2.length(); j++) {
            H[1][j+1] = j;
            H[0][j+1] = INFINITY;
        }
        int[] DA = new int[alphabetLength];
        Arrays.fill(DA, 0);
        for(int i = 1; i<=s1.length(); i++) {
            int DB = 0;
            for(int j = 1; j<=s2.length(); j++) {
                int i1 = DA[s2.charAt(j-1)];
                int j1 = DB;
                int d = ((s1.charAt(i-1)==s2.charAt(j-1))?0:1);
                if(d==0) DB = j;
                H[i+1][j+1] =
                        min(H[i][j]+d,
                                H[i+1][j] + 1,
                                H[i][j+1]+1,
                                H[i1][j1] + (i-i1-1) + 1 + (j-j1-1));
            }
            DA[s1.charAt(i-1)] = i;
        }
        return H[s1.length()+1][s2.length()+1];
    }
    private static int min(int ... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

}
