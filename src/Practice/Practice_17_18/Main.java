package Practice.Practice_17_18;

import java.io.*;

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
