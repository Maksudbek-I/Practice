package Practice.Practice_9;

public class Handler implements EmployeeHandler {
    @Override
    public void doSome(Employee employee) {
        System.out.println(employee);
    }
}
