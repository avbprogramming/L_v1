import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Levenshtein {

    public static void main (String[] args) throws IOException {
        System.out.println("Левенштейн");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое слово: ");
        String s1 = scanner.nextLine();
        System.out.println("Введите второе слово: ");
        String s2 = scanner.nextLine();
        System.out.println("Какое количество раз вы хотите проверить скорость выполнения функции: ");
        int count = Integer.parseInt(scanner.nextLine());

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i < s1.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Расстояние преобразования слов: " + LevenshteinMemory.computeLevenshteinDistanceDP(s1, s2));
        System.out.println("Скорость выполнения каждого метода записаны в файл.");

        long RecursionCurrentTime = System.nanoTime();
        for (int i = 0 ; i <count; i++ ) {
            Recursion.computeLevenshteinDistance(s1, s2);
        }
        long RecursionFinalTime = ((System.nanoTime()- RecursionCurrentTime) / count);
        System.out.println("Левенштейн с рекурсии. Запусков:  " + count + " раз. Среднее время выполнения: " + RecursionFinalTime);


        long RecursionWithMemoryCurrentTime = System.nanoTime();
        for (int i = 0 ; i <count; i++ ) {
            RecursionWithMemory.minDis(s1, s2, s1.length(), s2.length(), dp);
        }
        long RecursionWithMemoryFinalTime = ((System.nanoTime()-RecursionWithMemoryCurrentTime) / count);
        System.out.println("Левештейн с рекурсией и памятью. Запусков: : " + count + " раз. Среднее время выполнения: " + RecursionWithMemoryFinalTime);


        long LevenshteinMemoryCurrentTime = System.nanoTime();
        for (int i = 0 ; i <count; i++ ) {
            LevenshteinMemory.computeLevenshteinDistanceDP(s1, s2);
        }
        long LevenshteinMemoryFinalTime =((System.nanoTime()-LevenshteinMemoryCurrentTime) / count);
        System.out.println("Левешнтейн с памятью. Запусков:  " + count + " раз. Среднее время выполнения: " + LevenshteinMemoryFinalTime);


        long DLACurrentTime = System.nanoTime();
        for (int i = 0 ; i <count; i++ ) {
            DLA.cdDLA(s1, s2);
        }
        long DLAFinalTime = ((System.nanoTime()- DLACurrentTime) / count);
        System.out.println("Дамерау - Левенштен. Запусков: " + count + " раз. Среднее время выполнения: " + DLAFinalTime);
        System.out.println("Расстояние преобразование с помощью Дамерау - Левенштейна " + DLA.cdDLA(s1,s2));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"));
        bufferedWriter.write("Расстояние преобразования слов: " + LevenshteinMemory.computeLevenshteinDistanceDP(s1, s2));
        bufferedWriter.newLine();
        bufferedWriter.write("Левенштейн с рекурсии. Запусков:  " + count + " раз. Среднее время выполнения: " + RecursionFinalTime);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.write("Левештейн с рекурсией и памятью. Запусков: : " + count + " раз. Среднее время выполнения: " + RecursionWithMemoryFinalTime);
        bufferedWriter.newLine();
        bufferedWriter.flush(); bufferedWriter.write("Левешнтейн с памятью. Запусков:  " + count + " раз. Среднее время выполнения: " + LevenshteinMemoryFinalTime);
        bufferedWriter.newLine();
        bufferedWriter.flush(); bufferedWriter.write("Дамерау - Левенштейн. Запусков: " + count + " раз. Среднее время выполнения: " + DLAFinalTime);
        bufferedWriter.newLine();
        bufferedWriter.flush(); bufferedWriter.write("Расстояние преобразование с помощью Дамерау - Левенштейна " + DLA.cdDLA(s1,s2));
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
//        String file = "/home/avb/Documents/Учеба/Java_project/output.xlsx";
//        String sheetname = "levenshtein";

    }
}