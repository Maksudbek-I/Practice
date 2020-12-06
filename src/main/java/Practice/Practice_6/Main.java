package Practice.Practice_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mas = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = r.nextInt(2001) - 1000;
                // System.out.printf("%6d", mas[i][j]);
            }
            // System.out.println();
        }
        // System.out.println();
        for (int i = 1; i < n; i++) {
            mas[i][0] += mas[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            mas[0][j] += mas[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (mas[i - 1][j] > mas[i][j - 1]) {
                    mas[i][j] += mas[i - 1][j];
                } else {
                    mas[i][j] += mas[i][j - 1];
                }
            }
        }
        System.out.println(mas[n - 1][n - 1]);
      /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d", mas[i][j]);
            }
            System.out.println();
        }
        */
    }


}
