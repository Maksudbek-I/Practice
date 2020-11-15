package Practice.Practice_19_20;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    Chat chat = new Chat();
    Thread thread = new Thread(()->chat.Client());
    thread.start();
    thread = new Thread(()-> {
        try {
            chat.Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
        thread.start();
    }



}
