package Practice.Practice_9;

import java.time.LocalDate;
import java.util.Random;

public class Employee {
    private String name, surname, number, location;
    private double salary;
    private final LocalDate year;
    Random r = new Random();

    public Employee(String name, String surname, String number, String location, double salary) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.location = location;
        this.salary = salary;
        this.year = LocalDate.of(r.nextInt(40) + 1965  ,r.nextInt(12) + 1,r.nextInt(28) +1);
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        salary = salary;
    }

    public LocalDate getEmployeeYear() {
        return year;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", year=" + year +
                '}';
    }
}


