package Practice.Practice_9;
import java.util.ArrayList;


public class Company {
    ArrayList<Employee> staff = new ArrayList<>();
    void hire(Employee employee) { staff.add(employee); }
    void hireAll(ArrayList<Employee> staff) {
        this.staff.addAll(staff);
    };
    void fire(int i) {
        this.staff.remove(i);
    }
    public void handleEmployees(EmployeeHandler handler, EmployeeSelector selector){

        for(int i = 0; i < staff.size(); i++)
        {
            if(selector.isNeedEmployee(staff.get(i)))
            {
                handler.doSome(staff.get(i));
            }
        }

    }
}
