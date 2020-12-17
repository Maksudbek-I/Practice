package Practice.Practice_25_26;

public class Main {

    public static void main(String[] args) {

        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.add(1, "1");
        myHashMap.add(2, "2");
        myHashMap.add(3, "3");
        myHashMap.add(11, "1");
        myHashMap.add(21, "1");
        myHashMap.add(1, "1.1");
        myHashMap.add(1, "1.1");
        myHashMap.remove(11);
        myHashMap.add(1, "1.2");
        for (String s: myHashMap)
            System.out.println(s);

    }
}
