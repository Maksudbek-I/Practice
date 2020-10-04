package Practice.Practice_7_8;

public class Operator implements EmployeePosition{

    /*
    private double baseSalary;
    @Override
    public double getBaseSalary() {
        return baseSalary;
    }
    */
    @Override
    public String getJobTitle() {
        return "Operator";
    }

    @Override
    public double calcSalary(double baseSalary) {
        //this.baseSalary = baseSalary;
        return baseSalary;
    }
}
