package Practice.Practice_23_24;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {

    private String localPath = "src/main/java/Practice_23_24/db.json";
    private String networkPath = "http://80.87.199.76:3000/tasks/";
    private String reportPath = "http://80.87.199.76:3000/reports/";
    private Gson gson = new Gson();
    private HttpClient httpClient = HttpClient.newHttpClient();
    private List<Task> taskList;
    private List<Report> reportList;
    private int id;

    public void execApp() throws IOException, InterruptedException {
        while (true) {

            Type type = new TypeToken<ArrayList<Report>>() {}.getType();
            List<Report> rp = null;
            try (FileReader r = new FileReader(localPath)) {
                rp = gson.fromJson(r, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
            reportList = rp;
            id = reportList.size()+1;

            Type collectionType = new TypeToken<Collection<Task>>() {
            }.getType();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(networkPath))
                    .build();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            taskList = gson.fromJson(response.body(), collectionType);
            if ( taskList.size()>reportList.size()) {
                for (int i = reportList.size(); i < taskList.size(); i++)
                    fileWriter(reporter(worker(taskList.get(i).getExpression())));
                id=id+1;
            }

            try {
                Thread.sleep((int) (Math.random() * 1000 + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private String reporter(double answer) {
        Report report = new Report(id, answer);
        String json = gson.toJson(report);
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create(reportPath))
                .setHeader("Content-Type", "application/json")
                .build();
        try {
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        java.lang.System.out.println(json);
        return json;
    }

    private double worker(String expression) {
        expression = expression.replace(" ", "");
        Pattern pattern = Pattern.compile("(?<first>[-]*\\d+)(?<sign>[*+/-])(?<second>[-]*\\d+)");
        Matcher matcher = pattern.matcher(expression);
        java.lang.System.out.println(expression);
        while (matcher.find()) {
            if (matcher.group("sign").contains("*"))
                return Integer.parseInt(matcher.group("first"))
                        * Integer.parseInt(matcher.group("second"));
            if (matcher.group("sign").contains("/"))
                return Math.ceil((100 *
                        Integer.parseInt(matcher.group("first"))
                        / Integer.parseInt(matcher.group("second"))))
                        / 100;
            if (matcher.group("sign").contains("+"))
                return Integer.parseInt(matcher.group("first"))
                        + Integer.parseInt(matcher.group("second"));
            if (matcher.group("sign").contains("-"))
                return Integer.parseInt(matcher.group("first"))
                        - Integer.parseInt(matcher.group("second"));
        }
        return 0;
    }

    private void fileWriter(String json) {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(localPath))) {
            line = reader.readLine();
            while (!line.equals("]") && line != null) {
                sb.append(line);
                if (line.endsWith("}"))
                    sb.append(",");
                sb.append("\n");
                line = reader.readLine();
            }
            sb.append(json);
            try (PrintWriter writer = new PrintWriter(localPath)) {
                writer.write(sb.toString() + "\n]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
