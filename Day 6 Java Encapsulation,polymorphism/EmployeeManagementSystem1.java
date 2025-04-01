interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;


    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public int getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getBaseSalary() {
        return baseSalary;
    }


    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }


    public String getDepartmentDetails() {
        return department;
    }


    public void assignDepartment(String deptName) {
        this.department = deptName;
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println("---------------------------");
    }
}
class FullTimeEmployee extends Employee {
    private double bonus;


    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }


    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;


    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }


    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}
public class EmployeeManagementSystem1 {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee(101, "Alice", 30000, 5000);
        emp1.assignDepartment("Finance");


        Employee emp2 = new PartTimeEmployee(102, "Bob", 10000, 20, 300);
        emp2.assignDepartment("Support");


        Employee emp3 = new FullTimeEmployee(103, "Charlie", 35000, 8000);
        emp3.assignDepartment("HR");
        Employee[] employees = { emp1, emp2, emp3 };
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
