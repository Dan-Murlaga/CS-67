package model;
import java.util.ArrayList;

public class Student extends Person {

    private String studentId;
    private ArrayList<Course> courses;
    private double GPA;

    public Student(String studentId, String name, int age, double GPA) {
        super(name, age);
        this.studentId = studentId;
        this.courses = new ArrayList<>();
        this.GPA = GPA;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void addCourse(Course course) {
        for (Course existingCourse : courses) {
            if (existingCourse.getCourseName().equalsIgnoreCase(course.getCourseName())) {
                return;
            }
        }
        courses.add(course);
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getGrade() {
        if (GPA >= 4.0) {
            return "A+";
        } else if (GPA >= 3.66) {
            return "A";
        } else if (GPA >= 3.33) {
            return "B";
        } else if (GPA >= 3.0) {
            return "C";
        } else if (GPA >= 2.5) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getStatus() {
        return GPA >= 2.5 ? "PASS" : "FAIL";
    }

    @Override
    public void displayDetails() {
        String courseNames = "";
        for (Course course : courses) {
            courseNames += course.getCourseName() + ", ";
        }
        // Remove the trailing comma and space
        if (!courseNames.isEmpty()) {
            courseNames = courseNames.substring(0, courseNames.length() - 2);
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + getName());
        System.out.println("Courses    : " + courseNames);
        System.out.println("Age        : " + getAge());
        System.out.println("GPA        : " + GPA);
        System.out.println("Grade      : " + getGrade());
        System.out.println("Status     : " + getStatus());
        System.out.println("-----------------------------------------------");
    }

    @Override
    public String toString() {
        String courseNames = "";
        for (Course course : courses) {
            courseNames += course.getCourseName() + ", ";
        }
        // Remove the trailing comma and space
        if (!courseNames.isEmpty()) {
            courseNames = courseNames.substring(0, courseNames.length() - 2);
        }
        return studentId + "|" + getName() + "|" + courseNames + "|" + getAge() + "|" + GPA;
    }
}