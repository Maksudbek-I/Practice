package Practice.Practice_4;
public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * 3.14;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * 3.14;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter() +
                '}';
    }
}