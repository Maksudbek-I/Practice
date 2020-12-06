package Practice.Practice_1;

import java.util.Scanner;

public class Sum {
    private int size, sum = 0;
    private int[] arr;

    public int summa() {
        Scanner in = new Scanner(System.in);
        size = in.nextInt();

        arr = new int[size];
        for (int i = 0; i < size; i++) {
            sum += in.nextInt();
        }
        return sum;
    }
}