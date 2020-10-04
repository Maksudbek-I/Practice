package Practice.Practice_7_8;

public class Employee {
    private String name, surname;
    private EmployeePosition employeePosition;
    private double salary;
    private double fullSalary;
    public Employee(String name, String surname, EmployeePosition employeePosition, double salary) {
        this.name = name;
        this.surname = surname;
        this.employeePosition = employeePosition;
        this.salary = salary;
        this.setFullSalary(salary);
    }
    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }
    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public double  getSalary() { return salary;}
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getFullSalary() {
        return fullSalary;
    }
    public void setFullSalary(double fullSalary) {
        this.fullSalary = this.employeePosition.calcSalary(salary);
    }
}
