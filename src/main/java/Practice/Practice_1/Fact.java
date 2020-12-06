package Practice.Practice_1;

import java.util.Scanner;

public class Fact {
    public void cFact(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k=1;
        do {
            k = k * n;
            n--;
        } while (n>1);
        System.out.println(k);
    }
}
