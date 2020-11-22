package Practice.Practice_21_22;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Json implements ItemsStore{
    static String path = "src\\main\\java\\Practice\\Practice_21_22\\data.json";
    static File file = new File(path);
    static Gson gson = new Gson();


    @Override
    public List<Item> getAll() {
        Type type = new TypeToken<ArrayList<Item>>(){}.getType();
        List<Item> items = null;
        try(FileReader fr = new FileReader(file)) {
            items = gson.fromJson(fr,type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public Item get(int id) {
        return null;
    }

    @Override
    public Item addItem(Item item) throws Exception {

        String search = "]";

        Charset charset = StandardCharsets.UTF_8;
        Path path = Paths.get(String.valueOf(file));
        Files.write(path,
                new String(Files.readAllBytes(path), charset).replace(search,",\n" + gson.toJson(item))
                        .getBytes(charset));
        FileWriter writer = new FileWriter(file,true);
        try {
            writer.write("]");
            //writer.write(gson.toJson(item));
        } catch (IOException e) {
            System.out.println("Problems writing to file");
        } finally {
            writer.close();
        }
        return item;
    }
    private boolean checkId(int id) {
        if (get(id) != null) {
            return true;
        }
        return false;
    }
    @Override
    public Item editItem(Item item) {
        return null;
    }

    @Override
    public void deleteItem(Item item) {

    }
}
