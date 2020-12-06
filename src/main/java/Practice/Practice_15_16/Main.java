package Practice.Practice_15_16;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Condition[] s = new Condition[6];
        s[1] = new Condition(1,2,2,5);
        s[2] = new Condition(4,6,3,4);
        s[3] = new Condition(6,2,4,5);
        s[4] = new Condition(3,5,3,5);
        s[5] = new Condition(5,3,1,3);
        s[0]= new Condition(1,2,2,5);;
        String[] action = new String[6];
        action[0]= "create_project";
        action[1]= "add_library";
        action[2]="restart";
        action[3]= "test";
        action[4]="deploy";
        action[5]= "drop_db";
        int k;
        Scanner in = new Scanner(System.in);
        int transition= in.nextInt();
        while(transition != -1){
            System.out.println(action[s[0].Num(transition)-1]);
            s[0]=s[s[0].Next(transition)];
            transition= in.nextInt();
        }
    }
}
