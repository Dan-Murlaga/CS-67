package model;
import java.util.ArrayList;

public class Course {
    
    private String courseName;
    private ArrayList<Student> students;
    private int studentCount;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
        this.studentCount = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            this.studentCount++;
        }
    }

    public void clearStudents() {
        this.students.clear();
        this.studentCount = 0;
    }

    public int getStudentCount() {
        return this.studentCount;
    }

    public String toString() {
        return courseName + ": " + studentCount + " students";
    }
}
