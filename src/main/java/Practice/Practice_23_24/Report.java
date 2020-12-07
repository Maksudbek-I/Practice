package Practice.Practice_23_24;


public class Report {
    private int id;
    private int taskId;
    private final String worker = "Igamberdyev";
    private double result;

    public Report(int id, int taskId, double result) {
        this.id = id;
        this.taskId = taskId;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getWorker() {
        return worker;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", worker='" + worker + '\'' +
                ", result=" + result +
                '}';
    }
}