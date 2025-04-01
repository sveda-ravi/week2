import java.util.*;
class Course {
    private String courseName;
    private String courseCode;
    private List<Student> enrolledStudents;


    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }


    public String getCourseName() {
        return courseName;
    }


    public String getCourseCode() {
        return courseCode;
    }


    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);
        }
    }


    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " (" + courseCode + ")");
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.getName());
        }
    }
}


class Student {
    private String name;
    private int studentId;
    private List<Course> enrolledCourses;


    public Student(String name, int id) {
        this.name = name;
        this.studentId = id;
        this.enrolledCourses = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public void addCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }


    public void viewCourses() {
        System.out.println("Student: " + name + " (ID: " + studentId + ")");
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}
class School {
    private String schoolName;
    private List<Student> students;


    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        students.add(student); // aggregation
    }


    public void showStudents() {
        System.out.println("School: " + schoolName);
        for (Student student : students) {
            System.out.println("  - " + student.getName());
        }
    }
}


public class SchoolSystemApp {
    public static void main(String[] args) {


        School school = new School("Greenwood High");


        Student alice = new Student("Alice", 101);
        Student bob = new Student("Bob", 102);
        school.addStudent(alice);
        school.addStudent(bob);


        Course math = new Course("Mathematics", "MATH101");
        Course physics = new Course("Physics", "PHY101");


        math.enrollStudent(alice);
        math.enrollStudent(bob);
        physics.enrollStudent(alice);


        System.out.println("\n--- School Students ---");
        school.showStudents();


        System.out.println("\n--- Courses for Each Student ---");
        alice.viewCourses();
        bob.viewCourses();


        System.out.println("\n--- Enrolled Students in Each Course ---");
        math.showEnrolledStudents();
        physics.showEnrolledStudents();
    }
}
