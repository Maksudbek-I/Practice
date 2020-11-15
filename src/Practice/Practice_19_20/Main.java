package Practice.Practice_19_20;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    Test test = new Test();
    Thread thread = new Thread(()->test.Client());
    thread.start();
    thread = new Thread(()-> {
        try {
            test.Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
        thread.start();
    }



}
