package Practice.Practice_7_8;

import java.util.Random;

public class Manager implements EmployeePosition {
    //private double baseSalary;
    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        Random r = new Random();
      //  this.setBaseSalary(baseSalary);
        return (baseSalary + (r.nextInt(25001) + 115000)*0.05);
    }

}
