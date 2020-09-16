package Practice.Practice_4;


public class ShapeTest {
    public String color;
    public boolean filled;

    public static void main(String[] args) {
        Shape obj_1 = new Circle(7,"red", true) ;
        System.out.println(obj_1);
        Shape obj_2 = new Rectangle("blue",true,34,23);
        System.out.println(obj_2);
        Shape obj_3 = new Square(14);
        obj_3.setColor("black");
        obj_3.setFilled(true);
        System.out.println(obj_3);
    }
}
