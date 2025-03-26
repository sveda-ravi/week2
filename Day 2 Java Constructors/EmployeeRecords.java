// Parent class: Worker
class Worker {
    public int workerID;           // public variable
    protected String department;   // protected variable
    private double salary;         // private variable

    // Constructor
    public Worker(int workerID, String department, double salary) {
        this.workerID = workerID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to set salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Public method to get salary
    public double getSalary() {
        return salary;
    }

    // Method to display worker details
    public void displayWorkerDetails() {
        System.out.println("Worker ID: " + workerID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass: Supervisor
class Supervisor extends Worker {
    private int teamSize;

    // Constructor for Supervisor
    public Supervisor(int workerID, String department, double salary, int teamSize) {
        super(workerID, department, salary);  // call parent constructor
        this.teamSize = teamSize;
    }

    // Method to display supervisor details
    public void displaySupervisorDetails() {
        System.out.println("Supervisor Worker ID (public): " + workerID);       // accessing public member
        System.out.println("Supervisor Department (protected): " + department); // accessing protected member
        System.out.println("Team Size: " + teamSize);
    }
}

// Main class to test
public class EmployeeRecords {
    public static void main(String[] args) {
        Worker worker = new Worker(101, "Finance", 50000.00);
        worker.displayWorkerDetails();

        System.out.println();

        Supervisor supervisor = new Supervisor(201, "IT", 80000.00, 10);
        supervisor.displaySupervisorDetails();

        // Using public getter to access private salary field
        System.out.println("Supervisor Salary (via getter): $" + supervisor.getSalary());

        // Updating salary using public setter
        supervisor.setSalary(90000.00);
        System.out.println("Updated Supervisor Salary: $" + supervisor.getSalary());
    }
}
