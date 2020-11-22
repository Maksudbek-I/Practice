package Practice.Practice_21_22;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static List<Item> items;
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("src\\main\\java\\Practice\\Practice_21_22\\data.json",true);
        try {

            writer.write("[\n");
        } catch (IOException e) {
            System.out.println("Problems writing to file");
        } finally {
            writer.close();
        }

        System.out.println("Что использовать?\n1 - http\n2 - json ");
        switch (in.nextInt()){
            case 1-> {
                Http http = new Http();
                work(http);
                break;
            }
            case 2-> {
                Json json = new Json();
                work(json);
                break;
            }
            default -> {
                System.out.println("Неправильный ввод");
                break;
            }

        }

    }
   public static void work(ItemsStore itemsStore){

       System.out.println("Какое действие совершить?" +
               "\n1 - получить все элементы" +
               "\n2 - получить элемент по id" +
               "\n3 - добваить элемент" +
               "\n4 - редактировать элемент" +
               "\n5 - удалить элемент");

       switch (in.nextInt()){
           case 1->{
               items = itemsStore.getAll();
               for (Item i: items) {
                   System.out.println(i);
               }
               items.clear();
               break;
           }
           case 2->{
               System.out.println(2);
               break;
           }
           case 3->{
               System.out.println("Введите id");
               int id = in.nextInt();
               if(id !=0){
                   items = itemsStore.getAll();
                   if(repeated(id, items)){
                       System.out.println(" такой id уже существует");
                       break;}
               }
               System.out.println("Введите далее: data, isGood, description");
               try {
                   itemsStore.addItem(new Item(id,in.next(),in.nextBoolean(),in.next()));
               } catch (Exception e) {
                   e.printStackTrace();
               }
               break;
           }
           case 4->{
               System.out.println(4);
               break;
           }
           case 5->{
               System.out.println(5);
               break;
           }

           default -> {
               System.out.println("Неправильный ввод");
               break;
           }
       }
       System.out.println("Продолжить?\n1 - да\n2 - нет");
       if (in.nextInt()==1)
           work(itemsStore);

   }
    public static boolean repeated(int id,List<Item> items){
        for (Item i: items) {
            if (i.getId()==id)
                return true;
        }
        return false;
    }
    /*
    static HttpClient httpClient = HttpClient.newHttpClient();
    static Gson gson = new Gson();
    public static void main(String[] args) throws IOException, InterruptedException {

        Item item = new Item(1, "asd", false, "SOME LONG TEXT");
        System.out.println(gson.toJson(item));

        Item fromJson = gson.fromJson("{\"name\":\"Name item\",\"price\":-43545,\"count\":34,\"description\":\"SOME LONG TEXT\"}", Item.class);
        System.out.println(fromJson);

        addItem(new Item(0, "asdd3d21", true, "DESCR FROM JAVA"));

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://80.87.199.76:3000/objects"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
    private static void addItem(Item item) throws IOException, InterruptedException {
        String body = gson.toJson(item);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create("http://80.87.199.76:3000/objects"))
                .setHeader("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
    */

}
