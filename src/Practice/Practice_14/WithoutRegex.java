package Practice.Practice_14;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

    public class WithoutRegex {
        public static void main(String[] args) throws Exception {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            if(N < 1 || N > 300)
                throw new Exception("Неверное количество правил");
            String[] primordial = new String[N];
            String[] change = new String[N];
            for (int i = 0; i < N; i++) {
                primordial[i] = in.next();
                change[i] = in.next();
            }
            String line = in.next();
            if(line.length()>100_000)
                throw new Exception("Слишком длинная строка");
            String result = StringUtils.replaceEach(line, primordial, change);
            System.out.println(result);
        }
    }


