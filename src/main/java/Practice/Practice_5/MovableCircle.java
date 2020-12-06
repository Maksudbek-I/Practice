package Practice.Practice_5;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;


    public MovableCircle(int radius) {
        this.radius = radius;
        this.center = new MovablePoint(0, 0);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void Move(int right, int down) {
        center.Move(right, down);
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}
