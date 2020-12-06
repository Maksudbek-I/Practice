package Practice.Practice_3.third;

import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Book book = new Book();
        book.setAuthor("J. K. Rowling");
        book.setName("Harry Potter and the Philosopher's Stone");
        book.setYear(1997);
        book.setPage(270);
        System.out.println(book.toString());
    }
}
