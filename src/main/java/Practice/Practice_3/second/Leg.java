package Practice.Practice_3.second;

public class Leg {
    private double leg_length;
    private int shoe_size;

    public double getLeg_length() {
        return leg_length;
    }

    public void setLeg_length(double leg_length) {
        this.leg_length = leg_length;
    }

    public int getShoe_size() {
        return shoe_size;
    }

    public void setShoe_size(int shoe_size) {
        this.shoe_size = shoe_size;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "leg_length=" + leg_length +
                ", shoe_size=" + shoe_size +
                '}';
    }
}