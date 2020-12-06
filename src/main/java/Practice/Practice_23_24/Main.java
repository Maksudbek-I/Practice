package Practice.Practice_23_24;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Worker r = new Worker();
        try {
            r.execApp();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
