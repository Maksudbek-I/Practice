package Practice.Practice_5;

public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0);
        point.Move(6, 7);
        System.out.println(point);
        point.Move(4, 3);
        System.out.println("MovablePoint" + point);
        MovableCircle circle = new MovableCircle(5);
        circle.Move(4, 9);
        System.out.println(circle);
        MovableRectangle rectangle = new MovableRectangle(10, 20, 27, 20);
        rectangle.Move(10, -1);
        System.out.println(rectangle);
        rectangle.setWidth(6);
        rectangle.setLength(6);
        System.out.println(rectangle);
    }
}
