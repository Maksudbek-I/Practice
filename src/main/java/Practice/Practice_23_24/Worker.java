package Practice.Practice_23_24;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private final String taskAddress = "http://80.87.199.76:3000/tasks";
    private final String reportAddress = "http://80.87.199.76:3000/reports";
    private final String filePath = "src/main/java/Practice/Practice_23_24/db.json";
    private final Gson gson = new Gson();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final File file = new File(filePath);
    private List<Integer> completedIdList = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();


    public Worker() {
        try {
            file.createNewFile();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            tasks = getAllTasks();
            for (Task task :
                    tasks) {
                if (!checkTask(task.getId())) {
                    postReport(new Report(0, task.getId(), solveTask(task)));
                    //System.out.println(new Report(0, task.getId(), solveTask(task)).toString());
                    saveTasks();
                }
            }
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 2) - 1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public List<Task> getAllTasks() {
        List<Task> items = null;
        Type collectionType = new TypeToken<Collection<Task>>() {
        }.getType();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(taskAddress))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            items = gson.fromJson(response.body(), collectionType);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    public boolean checkTask(int id)
    {
        for (int completedId : completedIdList)
        {
            if (completedId == id)
                return true;
        }
        return false;
    }

    public void postReport(Report report) {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(report)))
                .uri(URI.create(reportAddress))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double solveTask(Task task) {
        String expression = task.getExpression().replace(" ", "");
        double foperand, soperand, result = 0;
        Pattern pattern = Pattern.compile("(?<foperand>[-]*\\d+)(?<operator>[-+*/])(?<soperand>[-]*\\d+)");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            foperand = Double.parseDouble(matcher.group("foperand"));
            soperand = Double.parseDouble(matcher.group("soperand"));
            switch (matcher.group("operator")) {
                case "-": {
                    result = foperand - soperand;
                    break;
                }
                case "+": {
                    result = foperand + soperand;
                    break;
                }
                case "*": {
                    result = foperand * soperand;
                    break;
                }
                case "/": {
                    result = foperand / soperand;
                    break;
                }
            }
            result = new BigDecimal(Double.toString(result)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        completedIdList.add(task.getId());		//добавляем id выполненного таска в список
        return result;
    }

    private void saveTasks() {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("[\n");
            int count = 1;
            for (Task task : tasks)
            {
                writer.write(gson.toJson(task));
                if (count != tasks.size())
                {
                    writer.write(",");
                }
                writer.write("\n");
                count++;
            }
            writer.write("]");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
