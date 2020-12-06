package Practice.Practice_3.second;

public class Hand {
    private double hand_length,forefinger_length;

    public double getHand_length() {
        return hand_length;
    }

    public void setHand_length(double hand_length) {
        this.hand_length = hand_length;
    }

    public double getForefinger_length() {
        return forefinger_length;
    }

    public void setForefinger_length(double forefinger_length) {
        this.forefinger_length = forefinger_length;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "hand_length=" + hand_length +
                ", forefinger_length=" + forefinger_length +
                '}';
    }
}
