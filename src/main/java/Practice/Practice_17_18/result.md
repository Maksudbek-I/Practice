####Arg.java
```java
package Practice.Practice_1;

public class Arg {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++)
            System.out.println(i);
    }

}
```
####Fact.java
```java
package Practice.Practice_1;

import java.util.Scanner;

public class Fact {
    public void cFact(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k=1;
        do {
            k = k * n;
            n--;
        } while (n>1);
        System.out.println(k);
    }
}
```
####First.java
```java
package Practice.Practice_1;

public class First {
    public static void main(String[] args) {
        Sum mas = new Sum();
        System.out.println(mas.summa());
        Rand arr = new Rand();
        arr.generation();
        Row harmonic = new Row();
        harmonic.build();
        Fact n = new Fact();
        n.cFact();
    }
}
```
####Rand.java
```java
package Practice.Practice_1;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Rand {
    private int[] arr;
    private Random r;

    public void generation() {
        arr = new int[10];
        r = new Random();
        for (int i = 0; i < 5; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        for (int i = 5; i < 10; i++) {
            arr[i] = r.nextInt(1000);
        }
        System.out.println("array = " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("array = " + Arrays.toString(arr));
    }
}
```
####Row.java
```java
package Practice.Practice_1;

public class Row {

    private double d;

    public void build() {

        for (int i = 1; i < 11; i++) {
            d = 1.0 / i;
            System.out.printf("n" + i + "=%.3f\n", d);
        }
    }
}
```
####Sum.java
```java
package Practice.Practice_1;

import java.util.Scanner;

public class Sum {
    private int size, sum = 0;
    private int[] arr;

    public int summa() {
        Scanner in = new Scanner(System.in);
        size = in.nextInt();

        arr = new int[size];
        for (int i = 0; i < size; i++) {
            sum += in.nextInt();
        }
        return sum;
    }
}
```
####Calculator.java
```java
package Practice.Practice_10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);

        JPanel panel = new JPanel();

        JTextField num_1 = new JTextField(10);
        num_1.setBounds(90, 50, 100, 30);
        panel.add(num_1);

        JTextField num_2 = new JTextField(10);
        num_2.setBounds(90, 180, 100, 30);
        panel.add(num_2);

        JLabel label = new JLabel("The result");
        label.setBounds(105, 225, 120, 30);
        panel.add(label);

        JTextField result = new JTextField();
        result.setBounds(90, 250, 100, 30);
        panel.add(result);

        JButton plus = new JButton("+");
        plus.addActionListener(
                action -> {
                    try {
                        Double sum = Double.parseDouble(num_1.getText()) + Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", sum));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        plus.setBounds(15, 100, 50, 50);
        panel.add(plus);

        JButton minus = new JButton("-");
        minus.addActionListener(
                action -> {
                    try {
                        Double dif = Double.parseDouble(num_1.getText()) - Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", dif));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        minus.setBounds(75, 100, 50, 50);
        panel.add(minus);

        JButton mult = new JButton("*");
        mult.addActionListener(
                action -> {
                    try {
                        Double prod = Double.parseDouble(num_1.getText()) * Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", prod));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        mult.setBounds(135, 100, 50, 50);
        panel.add(mult);


        JButton division = new JButton("/");
        division.addActionListener(
                action -> {
                    try {
                        Double quot = Double.parseDouble(num_1.getText()) / Double.parseDouble(num_2.getText());
                        result.setText(String.format("%.4f", quot));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
        );
        division.setBounds(195, 100, 50, 50);
        panel.add(division);

        add(panel);
        panel.setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
```
####Main.java
```java
package Practice.Practice_10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
```
####Threads.java
```java
package Practice.Practice_11;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Threads {

    static int totalSum;
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            work(i, false);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);

        totalSum = 0;
        startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI, false));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);

        threads.clear();
        totalSum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI, true));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum);
    }

    private static void work(int i, boolean synchr) {
        long startTime = System.currentTimeMillis();
        long result;
        if (synchr)
            result = doHardWork_synchronized(i * 100, 100_000_000);
        else
            result = doHardWork(i * 100, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private synchronized static long doHardWork_synchronized(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * Math.abs(start - i) * Math.sqrt(start + i);
            totalSum++;
        }
        return a;
    }
    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * Math.abs(start - i) * Math.sqrt(start + i);
            totalSum++;
        }
        return a;
    }
}
```
####Colors.java
```java
package Practice.Practice_12;

public enum Colors {
    BLUE("\u001B[34m"),
    RED("\u001B[91m"),
    YELLOW("\u001B[93m");

    private final String code;

    Colors(String code) {
        this.code = code;
    }

    public String getColorCode() {
        return code;
    }
}
```
####Main.java
```java
package Practice.Practice_12;

public class Main {
    public static void main(String[] args) {
        colorCaption("— Поторопись! У нас сейчас котлетки", Colors.BLUE);
        colorCaption("— С макарошками?", Colors.RED);
        colorCaption("—Нет, с пюрешкой!", Colors.YELLOW);
    }

    public static void colorCaption(String phrase, Colors color) {
        System.out.println(color.getColorCode() + phrase + "\u001B[0m");
    }
}
```
####Country.java
```java
package Practice.Practice_13;

public class Country {
    private int population;

    public void addPopulation(int population) throws MyException
    {
        if(population<=0)
            throw new MyException();
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "population=" + population +
                '}';
    }
}
```
####Main.java
```java
package Practice.Practice_13;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Country country = new Country();

        try {
            int population = Integer.parseInt(new Scanner(System.in).nextLine());
            country.addPopulation(population);
        } catch (MyException ex) {
            System.out.println("Население страны не может быть меньше 1 человека");
        } catch (NumberFormatException ex) {
            System.out.println("Неправильный формат числа");
        } finally {
            System.out.println(country);
        }

        throw new MyRuntimeException();


    }
}
```
####MyException.java
```java
package Practice.Practice_13;

public class MyException extends RuntimeException{
}
```
####MyRuntimeException.java
```java
package Practice.Practice_13;

public class MyRuntimeException extends RuntimeException {
}
```
####Regex.java
```java
package Practice.Practice_14;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Regex {
        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int N = Integer.parseInt(in.nextLine());
            HashMap<String, String> condition = new HashMap<>();
            for (int i = 0; i < N; i++) {
                condition.put(in.next(), in.next());
            }
            String line = in.next();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < condition.size(); i++) {
                sb.append(condition.keySet().toArray()[i]);
                if(i < condition.size()-1){
                    sb.append("|");
                }
            }
            Pattern pt = Pattern.compile(sb.toString());
            Matcher mt = pt.matcher(line);
            String result = mt.replaceAll(r -> condition.get(r.group()));
            System.out.println(result);
        }
    }
```
####WithoutRegex.java
```java
package Practice.Practice_14;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

    public class WithoutRegex {
        public static void main(String[] args) throws Exception {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            if(N < 1 || N > 300)
                throw new Exception("Неверное количество правил");
            String[] primordial = new String[N];
            String[] change = new String[N];
            for (int i = 0; i < N; i++) {
                primordial[i] = in.next();
                change[i] = in.next();
            }
            String line = in.next();
            if(line.length()>100_000)
                throw new Exception("Слишком длинная строка");
            String result = StringUtils.replaceEach(line, primordial, change);
            System.out.println(result);
        }
    }


```
####Condition.java
```java
package Practice.Practice_15_16;

public class Condition {
    private int action_0, action_1, step_0, step_1;

    public Condition(int action_0, int action_1, int step_0, int step_1) {
        this.action_0 = action_0;
        this.action_1 = action_1;
        this.step_0 = step_0;
        this.step_1 = step_1;
    }
    int Next(int num){
        if(num==0)
            return step_0;
        else
            return step_1;
    }
    int Num(int num){
        if(num==0)
            return action_0;
        else
            return action_1;
    }
}
```
####Main.java
```java
package Practice.Practice_15_16;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Condition[] s = new Condition[6];
        s[1] = new Condition(1,2,2,5);
        s[2] = new Condition(4,6,3,4);
        s[3] = new Condition(6,2,4,5);
        s[4] = new Condition(3,5,3,5);
        s[5] = new Condition(5,3,1,3);
        s[0]= new Condition(1,2,2,5);;
        String[] action = new String[6];
        action[0]= "create_project";
        action[1]= "add_library";
        action[2]="restart";
        action[3]= "test";
        action[4]="deploy";
        action[5]= "drop_db";
        int k;
        Scanner in = new Scanner(System.in);
        int transition= in.nextInt();
        while(transition != -1){
            System.out.println(action[s[0].Num(transition)-1]);
            s[0]=s[s[0].Next(transition)];
            transition= in.nextInt();
        }
    }
}
```
####Main.java
```java
package Practice.Practice_17_18;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
        public static void copy (File file, PrintWriter writer){

            String mainFilePath = file.getAbsolutePath();
            try {
                try (
                        BufferedReader reader = new BufferedReader(new FileReader(mainFilePath))) {
                    String line = reader.readLine();
                    writer.write("####" + file.getName() + "\n");
                    writer.write("```java\n");
                    while (line != null) {
                        writer.write(line);
                        writer.write('\n');
                        line = reader.readLine();
                    }
                    writer.write("```\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Incorrect file path");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static void search(String path, PrintWriter writer){
        File file = new File(path);
        if(file.isDirectory()){
            String[] list = file.list();
            for (String s : list) {
                search(file.getAbsolutePath()+ "/"+ s, writer);
            }
        }else {
            copy(file, writer);
        }
    }
        public static void main (String[]args){
            String basePath = "C:\\Users\\migam\\IdeaProjects\\Practice\\src";
            File file = new File(basePath);
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("C:\\Users\\migam\\IdeaProjects\\Practice\\src\\Practice\\Practice_17_18/result.md");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            search(file.getAbsolutePath(), writer );
            writer.close();
        }
}
```
####result.md
```java
```
####Ball.java
```java
package Practice.Practice_2;

public class Ball {
    private int size;
    private String color;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}

```
####Book.java
```java
package Practice.Practice_2;

public class Book {
    private int pages;
    String author, name;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
```
####Dog.java
```java
package Practice.Practice_2;

public class Dog {
    private String name;
    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeToHuman() {
        return age * 7;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```
####DogNursery.java
```java
package Practice.Practice_2;

import java.util.ArrayList;

public class DogNursery {
    static ArrayList<Dog> arr;

    public static void main(String[] args) {


        arr = new ArrayList<Dog>();
        addDog(new Dog("Bobik", 3));
        System.out.println("Dog{name='" + arr.get(0).getName() + "', age=" + arr.get(0).getAge() + "}");
        System.out.println("Human age = " + arr.get(0).getAgeToHuman());

        addDog(new Dog());
        arr.get(1).setName("Rex");
        arr.get(1).setAge(6);
        System.out.println(arr.get(1).toString());
        System.out.println("Human age = " + arr.get(1).getAgeToHuman());
    }

    public static void addDog(Dog dog) {
        arr.add(dog);
    }
}
```
####Shape.java
```java
package Practice.Practice_2;

public class Shape {
    private int width, length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }


}
```
####Tester.java
```java
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
```
####Circle.java
```java
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

```
####CircleTest.java
```java
package Practice.Practice_3.first;

import java.util.Scanner;

public class CircleTest {
    private static int temp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Circle okr = new Circle();
        temp = in.nextInt();
        okr.setxCenter(temp);
        temp = in.nextInt();
        okr.setyCenter(temp);
        temp = in.nextInt();
        okr.setRadius(temp);


        System.out.printf("%s%d%s%d%s%d", "x0 = ", okr.getxCenter(),
                " y0 = ", okr.getyCenter(), " radius = ", okr.getRadius());
    }
}
```
####Hand.java
```java
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
```
####Head.java
```java
package Practice.Practice_3.second;

public class Head {
    private String hair_Color, eyes_Color;

    public String getHair_Color() {
        return hair_Color;
    }

    public void setHair_Color(String hair_Color) {
        this.hair_Color = hair_Color;
    }

    public String getEyes_Color() {
        return eyes_Color;
    }

    public void setEyes_Color(String eyes_Color) {
        this.eyes_Color = eyes_Color;
    }

    @Override
    public String toString() {
        return "Head{" +
                "hair_Color='" + hair_Color + '\'' +
                ", eyes_Color='" + eyes_Color + '\'' +
                '}';
    }
}
```
####Human.java
```java
package Practice.Practice_3.second;

public class Human {
    private Head head;
    private Leg leg;
    private Hand hand;
    private String name;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" + '\n' +
                "name='" + name + "'\n" +
                head.toString() + '\n' +
                hand.toString() + '\n' +
                leg.toString() + '\n' +
                '}';
    }
}
```
####HumanTest.java
```java
package Practice.Practice_3.second;

import java.util.Scanner;

public class HumanTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Human man = new Human();
        man.setName("Mark");
        man.setHead(new Head());
        man.getHead().setHair_Color("brown");
        man.getHead().setEyes_Color("blue");
        man.setHand(new Hand());
        man.getHand().setHand_length(61.5);
        man.getHand().setForefinger_length(7.2);
        man.setLeg(new Leg());
        man.getLeg().setLeg_length(80.5);
        man.getLeg().setShoe_size(43);
        System.out.println(man.toString());
    }
}
```
####Leg.java
```java
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
```
####Book.java
```java
package Practice.Practice_3.third;

public class Book {
    private String author, name;
    private int year, page;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", page=" + page +
                '}';
    }
}
```
####BookTest.java
```java
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
```
####Circle.java
```java
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
```
####Rectangle.java
```java
package Practice.Practice_4;


public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter() +
                '}';
    }
}
```
####Shape.java
```java
package Practice.Practice_4;
public abstract class Shape {
    private String color;
    private boolean filled;
    public Shape() {
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    //public abstract String toString();
}
```
####ShapeTest.java
```java
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
```
####Square.java
```java
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
```
####Main.java
```java
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
```
####Movable.java
```java
package Practice.Practice_5;

public interface Movable {
    void Move(int right, int down);
}
```
####MovableCircle.java
```java
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
```
####MovablePoint.java
```java
package Practice.Practice_5;

public class MovablePoint implements Movable {
    private int x, y, down, right;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void Move(int right, int down) {
        x += right;
        y += down;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
```
####MovableRectangle.java
```java
package Practice.Practice_5;

public class MovableRectangle implements Movable {
    private int x1, x2, y1, y2, width, length;

    public MovableRectangle(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        if (x2 < x1)
            x1 = x1 ^ x2 ^ (x2 = x1);
        if (y2 > y1)
            y1 = y1 ^ y2 ^ (y2 = y1);
        width = y1 - y2;
        length = x2 - x1;
        MovablePoint upLeft = new MovablePoint(x1, y1);
        MovablePoint downRight = new MovablePoint(x2, y2);

    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        this.y2 = this.y1 - width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        this.x2 = x1 + length;
    }

    @Override
    public void Move(int right, int down) {
        this.y1 -= down;
        this.y2 -= down;
        this.x1 += right;
        this.x2 += right;

    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
```
####Main.java
```java
package Practice.Practice_6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] mas = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = r.nextInt(2001) - 1000;
                // System.out.printf("%6d", mas[i][j]);
            }
            // System.out.println();
        }
        // System.out.println();
        for (int i = 1; i < n; i++) {
            mas[i][0] += mas[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            mas[0][j] += mas[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (mas[i - 1][j] > mas[i][j - 1]) {
                    mas[i][j] += mas[i - 1][j];
                } else {
                    mas[i][j] += mas[i][j - 1];
                }
            }
        }
        System.out.println(mas[n - 1][n - 1]);
      /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d", mas[i][j]);
            }
            System.out.println();
        }
        */
    }


}
```
####Company.java
```java
package Practice.Practice_7_8;
import java.util.Comparator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> staff = new ArrayList<>();
    private double income;
    void hire(Employee employee) { staff.add(employee); }
    void hireAll(ArrayList<Employee> staff) {
        this.staff.addAll(staff);
    };
    void fire(int i) {
        this.staff.remove(i);
    }
    double getIncome(){
        double income = 0;
        for (Employee i : staff) {
            if(i.getEmployeePosition().getJobTitle() == "Manager"){
            income = income + (i.getEmployeePosition().calcSalary(i.getSalary()) - i.getSalary()) * 20; // i.getEmployeePosition().getBaseSalary()
            }
        }
        return income;
    };
    public void staffSorting() {
        staff.sort(Comparator.comparing(Employee::getFullSalary));
    }
    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> top = new ArrayList<>();
        for (int i = staff.size() - 1; i > (staff.size() - count); i--) {
            top.add(staff.get(i));
        }
        return top;
    }
    public List<Employee> getLowestSalaryStaff(int count){
        return staff.subList(0,count);
    }
    public int getStaffSize(){
        return staff.size();
    }
    public void recalculationSalary(){
        for (Employee i: staff) {
            i.setFullSalary(i.getSalary());
        }
    }
}
```
####Employee.java
```java
package Practice.Practice_7_8;

public class Employee {
    private String name, surname;
    private EmployeePosition employeePosition;
    private double salary;
    private double fullSalary;
    public Employee(String name, String surname, EmployeePosition employeePosition, double salary) {
        this.name = name;
        this.surname = surname;
        this.employeePosition = employeePosition;
        this.salary = salary;
        this.setFullSalary(salary);
    }
    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }
    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public double  getSalary() { return salary;}
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getFullSalary() {
        return fullSalary;
    }
    public void setFullSalary(double fullSalary) {
        this.fullSalary = this.employeePosition.calcSalary(salary);
    }
}
```
####EmployeePosition.java
```java
package Practice.Practice_7_8;

import java.util.Random;

public interface EmployeePosition {
  //  double getBaseSalary();
    String getJobTitle();
    double calcSalary(double baseSalary);
}
```
####Main.java
```java
package Practice.Practice_7_8;
import java.util.Random;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Company oriflame = new Company();
        for(int i = 0; i < 180; i++){
            oriflame.hire(new Employee("model" + String.valueOf(i), "Operator",new Operator(), (r.nextInt(3) + 1)*15000));
        }
        for(int i = 0; i < 80; i++){
            oriflame.hire(new Employee("model" + String.valueOf(i), "Manager", new Manager(), (r.nextInt(3) + 1)*30000));
        }
        ArrayList<Employee> TopManagers = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            TopManagers.add(new Employee("model" + String.valueOf(i), "TopManagers",new TopManager(oriflame), (r.nextInt(3) + 1)*50000));
        }
        oriflame.hireAll(TopManagers);
        oriflame.staffSorting();
        System.out.println("Top workers of the first month");
        for (Employee top: oriflame.getTopSalaryStaff(15)) {
            System.out.println(top.getFullSalary());
        }
        System.out.println("Worst workers of the first month");
        for (Employee staff: oriflame.getLowestSalaryStaff(30)) {
            System.out.println(staff.getFullSalary());
        }

        for (int i = 0; i < (int)(oriflame.getStaffSize()*0.5); i++){
            oriflame.fire(r.nextInt(oriflame.getStaffSize() + 1));
        }
        oriflame.recalculationSalary();
        System.out.println("Top workers of the second month");
        for (Employee top: oriflame.getTopSalaryStaff(15)) {
            System.out.println(top.getFullSalary());
        }
        System.out.println("Worst workers of the second month");
        for (Employee staff: oriflame.getLowestSalaryStaff(30)) {
            System.out.println(staff.getFullSalary());
        }




    }
}
```
####Manager.java
```java
package Practice.Practice_7_8;

import java.util.Random;

public class Manager implements EmployeePosition {
    //private double baseSalary;
    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        Random r = new Random();
      //  this.setBaseSalary(baseSalary);
        return (baseSalary + (r.nextInt(25001) + 115000)*0.05);
    }

}
```
####Operator.java
```java
package Practice.Practice_7_8;

public class Operator implements EmployeePosition{

    /*
    private double baseSalary;
    @Override
    public double getBaseSalary() {
        return baseSalary;
    }
    */
    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        //this.baseSalary = baseSalary;
        return baseSalary;
    }
}
```
####TopManager.java
```java
package Practice.Practice_7_8;

public class TopManager implements EmployeePosition {
    private Company company;

    public TopManager(Company company)
    {
        this.company=company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if(company.getIncome()>10000000)
            return baseSalary*2.5;
        return baseSalary;
    }
}
```
####Company.java
```java
package Practice.Practice_9;
import java.util.ArrayList;


public class Company {
    ArrayList<Employee> staff = new ArrayList<>();
    void hire(Employee employee) { staff.add(employee); }
    void hireAll(ArrayList<Employee> staff) {
        this.staff.addAll(staff);
    };
    void fire(int i) {
        this.staff.remove(i);
    }
    public void handleEmployees(EmployeeHandler handler, EmployeeSelector selector){

        for(int i = 0; i < staff.size(); i++)
        {
            if(selector.isNeedEmployee(staff.get(i)))
            {
                handler.doSome(staff.get(i));
            }
        }

    }
}
```
####Employee.java
```java
package Practice.Practice_9;

import java.time.LocalDate;
import java.util.Random;

public class Employee {
    private String name, surname, number, location;
    private double salary;
    private final LocalDate year;
    Random r = new Random();

    public Employee(String name, String surname, String number, String location, double salary) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.location = location;
        this.salary = salary;
        this.year = LocalDate.of(r.nextInt(40) + 1965  ,r.nextInt(12) + 1,r.nextInt(28) +1);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        salary = salary;
    }

    public LocalDate getEmployeeYear() {
        return year;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", year=" + year +
                '}';
    }
}


```
####EmployeeHandler.java
```java
package Practice.Practice_9;

public interface EmployeeHandler {
    void doSome(Employee employee);
}
```
####EmployeeSelector.java
```java
package Practice.Practice_9;

public interface EmployeeSelector {
    boolean isNeedEmployee(Employee employee);
}
```
####Handler.java
```java
package Practice.Practice_9;

public class Handler implements EmployeeHandler {
    @Override
    public void doSome(Employee employee) {
        System.out.println(employee);
    }
}
```
####Main.java
```java
package Practice.Practice_9;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random r = new Random();
        Handler hndl = new Handler();
        Selector slct = new Selector();
       // System.out.println(company.staff.get(0).getSalary());

        company.handleEmployees(hndl, slct);
        for (int i = 0; i<100;i++ ){
            company.hire(new Employee(
                    "Bob"+i,
                    "Cooper" + (r.nextInt(20) + 1),
                    "8-906-111-" + (r.nextInt(9001) + 1000),
                    "Moscow",
                    r.nextInt(12_001) + 20000));
        }
        System.out.println("All information about those who earn more than 30,000");
        company.handleEmployees(hndl, slct);
        System.out.println();
        System.out.println("The last digit of the number is 0");
        company.handleEmployees(new EmployeeHandler() {
            @Override
            public void doSome(Employee employee) {
                System.out.println(employee.getName() +": " + employee.getNumber());
            }
        }, new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return (employee.getNumber().charAt(13) == '0');
            }
        });
        System.out.println();
        System.out.println("How much do people born in 1990 earn");
        company.handleEmployees(
                employee -> System.out.println(employee.getName()+
                        ": " + employee.getEmployeeYear() +
                        ": " + employee.getSalary()),
                employee -> employee.getEmployeeYear().getYear() == 1990
        );

    }
}
```
####Selector.java
```java
package Practice.Practice_9;

public class Selector implements EmployeeSelector {
    @Override
    public boolean isNeedEmployee(Employee employee) {
        return (employee.getSalary()>30_000);
    }
}
```
