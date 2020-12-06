package Practice.Practice_1;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Rand {
    private int[] arr;
    private Random r;

    public void generation() {
        arr = new int[10];
        r = new Random();
        for (int i = 0; i < 5; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        for (int i = 5; i < 10; i++) {
            arr[i] = r.nextInt(1000);
        }
        System.out.println("array = " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("array = " + Arrays.toString(arr));
    }
}
