import java.util.*;
class Faculty {
    private String name;
    private String facultyId;

    public Faculty(String name, String facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void showInfo() {
        System.out.println("Faculty: " + name + " (ID: " + facultyId + ")");
    }
}
class Department {
    private String name;
    private List<Faculty> facultyList;

    public Department(String name) {
        this.name = name;
        this.facultyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public void showDepartmentInfo() {
        System.out.println("Department: " + name);
        for (Faculty f : facultyList) {
            System.out.println("  - " + f.getName());
        }
    }
}
class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.getName().equalsIgnoreCase(deptName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found.");
    }
    public void showUniversityInfo() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            dept.showDepartmentInfo();
        }
    }
    public void deleteUniversity() {
        System.out.println("\nDeleting University: " + name);
        departments.clear();
    }
}
public class UniversityStructureDemo {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Smith", "F101");
        Faculty f2 = new Faculty("Dr. Jane", "F102");
        System.out.println("Independent Faculty:");
        f1.showInfo();
        f2.showInfo();
        University uni = new University("Global University");
        uni.addDepartment("Engineering");
        uni.addDepartment("Mathematics");
        uni.assignFacultyToDepartment("Engineering", f1);
        uni.assignFacultyToDepartment("Mathematics", f2);
        System.out.println("\nUniversity Structure:");
        uni.showUniversityInfo();
        uni.deleteUniversity();
        System.out.println("\nFaculty after University Deletion:");
        f1.showInfo();
        f2.showInfo();
    }
}
