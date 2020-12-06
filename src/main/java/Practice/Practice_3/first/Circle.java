package Practice.Practice_3.first;

public class Circle {
    private int xCenter, yCenter, radius;

    public int getxCenter() {
        return xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "xCenter=" + xCenter +
                ", yCenter=" + yCenter +
                ", radius=" + radius +
                '}';
    }
}

