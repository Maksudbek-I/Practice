package Practice.Practice_3.second;

import java.util.Scanner;

public class HumanTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Human man = new Human();
        man.setName("Mark");
        man.setHead(new Head());
        man.getHead().setHair_Color("brown");
        man.getHead().setEyes_Color("blue");
        man.setHand(new Hand());
        man.getHand().setHand_length(61.5);
        man.getHand().setForefinger_length(7.2);
        man.setLeg(new Leg());
        man.getLeg().setLeg_length(80.5);
        man.getLeg().setShoe_size(43);
        System.out.println(man.toString());
    }
}
