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