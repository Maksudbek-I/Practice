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
