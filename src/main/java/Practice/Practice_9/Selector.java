package Practice.Practice_9;

public class Selector implements EmployeeSelector {
    @Override
    public boolean isNeedEmployee(Employee employee) {
        return (employee.getSalary()>30_000);
    }
}
