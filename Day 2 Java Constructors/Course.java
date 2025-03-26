public class Course {
    private String courseName;
    private int duration;      // in months
    private double fee;
    private static String instituteName = "Default Institute";  // Class variable

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
    }

    // Class method to update institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    // Main method to test
    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 3, 300.0);
        Course c2 = new Course("Web Development", 4, 400.0);

        System.out.println("Before updating institute name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
        System.out.println();

        // Update institute name
        Course.updateInstituteName("Sveda Tech Academy");
        System.out.println();

        System.out.println("After updating institute name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
