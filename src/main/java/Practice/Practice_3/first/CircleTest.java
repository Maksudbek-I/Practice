package Practice.Practice_3.first;

import java.util.Scanner;

public class CircleTest {
    private static int temp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Circle okr = new Circle();
        temp = in.nextInt();
        okr.setxCenter(temp);
        temp = in.nextInt();
        okr.setyCenter(temp);
        temp = in.nextInt();
        okr.setRadius(temp);


        System.out.printf("%s%d%s%d%s%d", "x0 = ", okr.getxCenter(),
                " y0 = ", okr.getyCenter(), " radius = ", okr.getRadius());
    }
}