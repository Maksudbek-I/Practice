package Practice.Practice_3.second;

public class Human {
    private Head head;
    private Leg leg;
    private Hand hand;
    private String name;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" + '\n' +
                "name='" + name + "'\n" +
                head.toString() + '\n' +
                hand.toString() + '\n' +
                leg.toString() + '\n' +
                '}';
    }
}
