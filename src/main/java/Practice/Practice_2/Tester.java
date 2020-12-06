package Practice.Practice_2;

public class Tester {
    public static void main(String[] args) {
        Shape obj_Shape = new Shape();
        obj_Shape.setLength(6);
        obj_Shape.setWidth(10);
        obj_Shape.getLength();
        obj_Shape.getWidth();
        System.out.println(obj_Shape.toString());

        Ball obj_Ball = new Ball();
        obj_Ball.setSize(5);
        obj_Ball.setColor("red");
        obj_Ball.getSize();
        obj_Ball.getColor();
        System.out.println(obj_Ball.toString());

        Book obj_Book = new Book();
        obj_Book.setAuthor("Stephen Hawking");
        obj_Book.setName("A brief history of time");
        obj_Book.setPages(232);
        obj_Book.getAuthor();
        obj_Book.getName();
        obj_Book.getPages();
        System.out.println(obj_Book.toString());

    }
}
