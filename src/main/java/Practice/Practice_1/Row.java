package Practice.Practice_1;

public class Row {

    private double d;

    public void build() {

        for (int i = 1; i < 11; i++) {
            d = 1.0 / i;
            System.out.printf("n" + i + "=%.3f\n", d);
        }
    }
}
