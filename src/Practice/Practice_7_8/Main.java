package Practice.Practice_7_8;
import java.util.Random;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Company oriflame = new Company();
        for(int i = 0; i < 180; i++){
            oriflame.hire(new Employee("model" + String.valueOf(i), "Operator",new Operator(), (r.nextInt(3) + 1)*15000));
        }
        for(int i = 0; i < 80; i++){
            oriflame.hire(new Employee("model" + String.valueOf(i), "Manager", new Manager(), (r.nextInt(3) + 1)*30000));
        }
        ArrayList<Employee> TopManagers = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            TopManagers.add(new Employee("model" + String.valueOf(i), "TopManagers",new TopManager(oriflame), (r.nextInt(3) + 1)*50000));
        }
        oriflame.hireAll(TopManagers);
        oriflame.staffSorting();
        System.out.println("Top workers of the first month");
        for (Employee top: oriflame.getTopSalaryStaff(15)) {
            System.out.println(top.getFullSalary());
        }
        System.out.println("Worst workers of the first month");
        for (Employee staff: oriflame.getLowestSalaryStaff(30)) {
            System.out.println(staff.getFullSalary());
        }

        for (int i = 0; i < (int)(oriflame.getStaffSize()*0.5); i++){
            oriflame.fire(r.nextInt(oriflame.getStaffSize() + 1));
        }
        oriflame.recalculationSalary();
        System.out.println("Top workers of the second month");
        for (Employee top: oriflame.getTopSalaryStaff(15)) {
            System.out.println(top.getFullSalary());
        }
        System.out.println("Worst workers of the second month");
        for (Employee staff: oriflame.getLowestSalaryStaff(30)) {
            System.out.println(staff.getFullSalary());
        }




    }
}