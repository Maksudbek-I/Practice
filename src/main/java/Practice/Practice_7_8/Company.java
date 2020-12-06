package Practice.Practice_7_8;
import java.util.Comparator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> staff = new ArrayList<>();
    private double income;
    void hire(Employee employee) { staff.add(employee); }
    void hireAll(ArrayList<Employee> staff) {
        this.staff.addAll(staff);
    };
    void fire(int i) {
        this.staff.remove(i);
    }
    double getIncome(){
        double income = 0;
        for (Employee i : staff) {
            if(i.getEmployeePosition().getJobTitle() == "Manager"){
            income = income + (i.getEmployeePosition().calcSalary(i.getSalary()) - i.getSalary()) * 20; // i.getEmployeePosition().getBaseSalary()
            }
        }
        return income;
    };
    public void staffSorting() {
        staff.sort(Comparator.comparing(Employee::getFullSalary));
    }
    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> top = new ArrayList<>();
        for (int i = staff.size() - 1; i > (staff.size() - count); i--) {
            top.add(staff.get(i));
        }
        return top;
    }
    public List<Employee> getLowestSalaryStaff(int count){
        return staff.subList(0,count);
    }
    public int getStaffSize(){
        return staff.size();
    }
    public void recalculationSalary(){
        for (Employee i: staff) {
            i.setFullSalary(i.getSalary());
        }
    }
}
