package Practice.Practice_9;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Random r = new Random();
        Handler hndl = new Handler();
        Selector slct = new Selector();
       // System.out.println(company.staff.get(0).getSalary());

        company.handleEmployees(hndl, slct);
        for (int i = 0; i<100;i++ ){
            company.hire(new Employee(
                    "Bob"+i,
                    "Cooper" + (r.nextInt(20) + 1),
                    "8-906-111-" + (r.nextInt(9001) + 1000),
                    "Moscow",
                    r.nextInt(12_001) + 20000));
        }
        System.out.println("All information about those who earn more than 30,000");
        company.handleEmployees(hndl, slct);
        System.out.println();
        System.out.println("The last digit of the number is 0");
        company.handleEmployees(new EmployeeHandler() {
            @Override
            public void doSome(Employee employee) {
                System.out.println(employee.getName() +": " + employee.getNumber());
            }
        }, new EmployeeSelector() {
            @Override
            public boolean isNeedEmployee(Employee employee) {
                return (employee.getNumber().charAt(13) == '0');
            }
        });
        System.out.println();
        System.out.println("How much do people born in 1990 earn");
        company.handleEmployees(
                employee -> System.out.println(employee.getName()+
                        ": " + employee.getEmployeeYear() +
                        ": " + employee.getSalary()),
                employee -> employee.getEmployeeYear().getYear() == 1990
        );

    }
}
