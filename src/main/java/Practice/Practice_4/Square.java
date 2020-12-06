package Practice.Practice_4;

public class Square extends Shape {

    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side ;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter() +
                '}';
    }
}