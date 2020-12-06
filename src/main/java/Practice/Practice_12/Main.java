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
