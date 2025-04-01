import java.util.ArrayList;
class Employee {
    private String name;
    private String position;


    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }


    public String getName() {
        return name;
    }


    public String getPosition() {
        return position;
    }


    @Override
    public String toString() {
        return "Employee Name: " + name + ", Position: " + position;
    }
}
class Department {
    private String departmentName;
    private ArrayList<Employee> employees;


    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }


    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }


    public String getDepartmentName() {
        return departmentName;
    }


    public ArrayList<Employee> getEmployees() {
        return employees;
    }


    @Override
    public String toString() {
        return "Department: " + departmentName;
    }
}


class Company {
    private String companyName;
    private ArrayList<Department> departments;


    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }
    public void addDepartment(Department department) {
        departments.add(department);
    }
    public void removeDepartment(Department department) {
        departments.remove(department);
    }
    public void showCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department department : departments) {
            System.out.println(department);
            for (Employee employee : department.getEmployees()) {
                System.out.println("  " + employee);
            }
        }
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Company " + companyName + " is being deleted. All departments and employees will be removed.");
        departments.clear();
        super.finalize();
    }
}


public class CompanyDepartmentEmployee {
    public static void main(String[] args) {

        Employee emp1 = new Employee("John Doe", "Software Engineer");
        Employee emp2 = new Employee("Jane Smith", "HR Manager");
        Employee emp3 = new Employee("Bill Gates", "CTO");



        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");
        dept1.addEmployee(emp1);
        dept2.addEmployee(emp2);
        Company company = new Company("TechCorp");
        company.addDepartment(dept1);
        company.addDepartment(dept2);
        dept1.addEmployee(emp3);
        company.showCompanyDetails();
        company = null;
        System.gc();
    }
}
