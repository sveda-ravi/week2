// Parent class: Student
class Students {
    public int rollNumber;        // public variable
    protected String name;        // protected variable
    private double CGPA;          // private variable

    // Constructor to initialize Student details
    public Students(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public method to get CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public method to set CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value.");
        }
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass: PostgraduateStudent
class PostgraduateStudent extends Students {

    // Constructor for PostgraduateStudent
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);  // Call the parent constructor
    }

    // Method to display PG student details
    public void displayPGDetails() {
        // Accessing the protected 'name' variable from the parent class
        System.out.println("Postgraduate Student Name: " + name);
    }
}

// Main class to test
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating a Student object
        Students student1 = new Student("John", 101, 8.5);
        student1.displayStudentDetails();

        // Modifying CGPA using public methods
        student1.setCGPA(9.0);
        System.out.println("Updated CGPA: " + student1.getCGPA());
        System.out.println();

        // Creating a PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Alice Smith", 9.5);
        pgStudent.displayStudentDetails();
        pgStudent.displayPGDetails();
    }
}
