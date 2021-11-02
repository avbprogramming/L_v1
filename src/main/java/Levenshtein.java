import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
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
        System.out.println("Среднее время выполнения рекурсии с учетом запуска: " + count + " раз. Среднее время выполнения: " + RecursionFinalTime);


        long RecursionWithMemoryCurrentTime = System.nanoTime();
        for (int i = 0 ; i <count; i++ ) {
            RecursionWithMemory.minDis(s1, s2, s1.length(), s2.length(), dp);
        }
        long RecursionWithMemoryFinalTime = ((System.nanoTime()-RecursionWithMemoryCurrentTime) / count);
        System.out.println("Среднее время выполнения рекурсии с использованием памяти и учетом запуска: " + count + " раз. Среднее время выполнения: " + RecursionWithMemoryFinalTime);


        long LevenshteinMemoryCurrentTime = System.nanoTime();
        for (int i = 0 ; i <count; i++ ) {
            LevenshteinMemory.computeLevenshteinDistanceDP(s1, s2);
        }
        long LevenshteinMemoryFinalTime =((System.nanoTime()-LevenshteinMemoryCurrentTime) / count);
        System.out.println("Среднее время выполнения с использованием памяти и учетом запуска: " + count + " раз. Среднее время выполнения: " + LevenshteinMemoryFinalTime);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"));
        bufferedWriter.write("Среднее время выполнения рекурсии с учетом запуска: " + count + " раз. Среднее время выполнения: " + RecursionFinalTime);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.write("Среднее время выполнения рекурсии с использованием памяти и учетом запуска: " + count + " раз. Среднее время выполнения: " + RecursionWithMemoryFinalTime);
        bufferedWriter.newLine();
        bufferedWriter.flush(); bufferedWriter.write("Среднее время выполнения с использованием памяти и учетом запуска: " + count + " раз. Среднее время выполнения: " + LevenshteinMemoryFinalTime);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
//        String file = "/home/avb/Documents/Учеба/Java_project/output.xlsx";
//        String sheetname = "levenshtein";

    }
}