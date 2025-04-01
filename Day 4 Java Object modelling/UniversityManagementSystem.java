import java.util.*;

// Student class
class Student {
    private String studentId;
    private String name;
    private List<Course> enrolledCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this); // association both ways
        System.out.println(name + " enrolled in course: " + course.getCourseName());
    }

    public void showCourses() {
        System.out.println("\nCourses enrolled by " + name + ":");
        for (Course c : enrolledCourses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}

// Professor class
class Professor {
    private String professorId;
    private String name;

    public Professor(String professorId, String name) {
        this.professorId = professorId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void assignToCourse(Course course) {
        course.setProfessor(this);
        System.out.println("Professor " + name + " assigned to course: " + course.getCourseName());
    }
}

// Course class
class Course {
    private String courseId;
    private String courseName;
    private List<Student> students;
    private Professor professor;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public void showCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

// Main class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create students
        Student s1 = new Student("S001", "Alice");
        Student s2 = new Student("S002", "Bob");

        // Create professors
        Professor p1 = new Professor("P001", "Dr. Smith");
        Professor p2 = new Professor("P002", "Dr. Johnson");

        // Create courses
        Course c1 = new Course("CSE101", "Introduction to Programming");
        Course c2 = new Course("CSE102", "Data Structures");

        // Assign professors
        p1.assignToCourse(c1);
        p2.assignToCourse(c2);

        // Students enroll in courses
        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);

        // Show details
        c1.showCourseDetails();
        c2.showCourseDetails();

        s1.showCourses();
        s2.showCourses();
    }
}
