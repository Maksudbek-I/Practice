package Practice.Practice_14;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Regex {
        public static void main(String[] args) throws Exception {

            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            if(N < 1 || N > 300)
                throw new Exception("Неверное количество правил");
            HashMap<String, String> condition = new HashMap<>();
            for (int i = 0; i < N; i++) {
                condition.put(in.next(), in.next());
            }
            String line = in.next();
            if(line.length()>100_000)
                throw new Exception("Слишком длинная строка");

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < condition.size(); i++) {
                sb.append(condition.keySet().toArray()[i]);
                if(i != condition.size()-1){
                    sb.append("|");
                }
            }
            Pattern pt = Pattern.compile(sb.toString());
            Matcher mt = pt.matcher(line);
            String result = mt.replaceAll(r -> condition.get(r.group()));
            System.out.println(result);

        }
    }

