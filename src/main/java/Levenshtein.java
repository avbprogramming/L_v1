import java.util.*;

public class Levenshtein {

    public static void main (String[] args){
        System.out.println("Левенштейн");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое слово: ");
        String s1 = scanner.nextLine();
        System.out.println("Введите второе слово: ");
        String s2 = scanner.nextLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        //jk
        for (int i = 0 ; i <10; i++ ) {
            long currentTime = System.currentTimeMillis();
      //  System.out.println("Левенштейн с памятью и рекурсией " + RecursionWithMemory.minDis(s1, s2, s1.length(), s2.length(), dp));
          System.out.println("Время выполнения без рекурсии " + LevenshteinMemory.computeLevenshteinDistanceDP(s1, s2));
            long finalTime = System.currentTimeMillis()-currentTime;
         System.out.println(finalTime);
        }

    /*    System.out.println("Рекурсный и без кэша " + Recursion.computeLevenshteinDistance(s1, s2));
        System.out.println("Время выполнения рекурсный и без кэша " + Recursion.difference);
        System.out.println("Нерекурсивный с памятью " + LevenshteinMemory.computeLevenshteinDistanceDP(s1, s2));
        System.out.println("Время выполнения без рекурсии " + LevenshteinMemory.difference);
        int n= s1.length(), m = s2.length();
       int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], -1);
        System.out.println("Левенштейн с памятью и рекурсией " + RecursionWithMemory.minDis(s1, s2, n, m, dp));
     //  System.out.println("Время выполнения с рекурсией с памятью " + RecursionWithMemory.timePass);
      //  System.out.println("RecursionWithMemory.startTimestamp " + RecursionWithMemory.startTimestamp);
      //  System.out.println("RecursionWithMemory.finishTimestamp " + RecursionWithMemory.finishTimestamp);
      //  System.out.println("RecursionWithMemory.startInstant " + RecursionWithMemory.startInstant.toEpochMilli());
      //  System.out.println("RecursionWithMemory.finishInstant) " + RecursionWithMemory.finishInstant.toEpochMilli());
    */
    }

}