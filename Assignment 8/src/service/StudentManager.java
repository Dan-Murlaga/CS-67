package service;

import exception.DuplicateStudentException;
import exception.StudentNotFoundException;
import interfacee.Manageable;
import model.Course;
import model.Student;

import java.io.*;
import java.util.*;

public class StudentManager implements Manageable {

    private final ArrayList<Student> students = new ArrayList<>();

    // Student ID -> Student
    private final HashMap<String, Student> studentMap = new HashMap<>();

    // Stores unique courses
    private final HashSet<Course> courses = new HashSet<>();

    private final Scanner sc;

    private final String FILE_NAME = "data/students.txt";

    public StudentManager(Scanner sc) {
        this.sc = sc;
        loadFromFile();
    }

    // ================= ADD STUDENT =================

    @Override
    public void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        String id = readNonEmptyString("Enter Student ID: ");

        try {
            if (studentMap.containsKey(id)) {
                throw new DuplicateStudentException(
                        "Student ID already exists!"
                );
            }

            String name = readNonEmptyString("Enter Name: ");
            String courseName = readNonEmptyString("Enter Course: ");

            int age = readInt("Enter Age: ");

            if (age < 5 || age > 100) {
                System.out.println("Age must be between 5 and 100.");
                return;
            }

            double GPA = readDouble("Enter GPA: ");

            if (GPA < 0 || GPA > 5) {
                System.out.println("GPA must be between 0 and 5.");
                return;
            }

            Student student = new Student(
                    id,
                    name,
                    age,
                    GPA
            );
            addStudentToCourse(student, courseName);

            while (true) {
                String addAnother = readNonEmptyString(
                        "Add student to another course? (Enter Done to finish): "
                );
                if (addAnother.equalsIgnoreCase("Done")) {
                    break;
                } else {
                    for (Course course : student.getCourses()) {
                        if (course.getCourseName().equalsIgnoreCase(addAnother)) {
                            System.out.println("Student is already enrolled in this course.");
                            continue;
                        }
                    }
                    addStudentToCourse(student, addAnother);
                }
            }

            students.add(student);
            studentMap.put(id, student);

            System.out.println("\nStudent added successfully!");
            System.out.println("Grade  : " + student.getGrade());
            System.out.println("Status : " + student.getStatus());

            saveToFile();

        } catch (DuplicateStudentException e) {
            System.out.println("Error: " + e.getMessage());

            boolean addToOtherCourse = readNonEmptyString(
                    "Add student to existing course? (Yes/No): "
            ).equalsIgnoreCase("Yes");

            if (addToOtherCourse) {
                Student existingStudent = studentMap.get(id);
                String courseName = readNonEmptyString("Enter Course: ");

                for (Course course : existingStudent.getCourses()) {
                    if (course.getCourseName().equalsIgnoreCase(courseName)) {
                        System.out.println("Student is already enrolled in this course.");
                        return;
                    }
                }

                addStudentToCourse(existingStudent, courseName);
                System.out.println("Student added to the course successfully!");
            }
        }
    }

    // ================= CREATE COURSE =================

    public void createCourse() {

        System.out.println("\n========== CREATE COURSE ==========");

        String courseName = readNonEmptyString("Enter Course Name: ");
        Course existingCourse = findCourse(courseName);

        if (existingCourse != null) {
            System.out.println("Course already exists.");
            return;
        }

        getOrCreateCourse(courseName);

        System.out.println("Course created successfully!");
    }

    private Course getOrCreateCourse(String courseName) {
        Course existingCourse = findCourse(courseName);
        if (existingCourse != null) {
            return existingCourse;
        }

        Course course = new Course(courseName);
        courses.add(course);
        return course;
    }

    private Course findCourse(String courseName) {
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }

    private void addStudentToCourse(Student student, String courseName) {
        Course course = getOrCreateCourse(courseName);
        student.addCourse(course);
        course.addStudent(student);
    }

    // ================= VIEW STUDENTS =================

    @Override
    public void viewStudents() {

        System.out.println("\n========== ALL STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.displayDetails();
        }

        System.out.println("Total Students: " + students.size());
    }

    // ================= SEARCH BY ID =================

    public void searchById() {

        System.out.println("\n========== SEARCH BY ID ==========");

        String id = readNonEmptyString("Enter Student ID: ");

        try {
            Student student = studentMap.get(id);

            if (student == null) {
                throw new StudentNotFoundException(
                        "Student with ID " + id + " not found."
                );
            }

            student.displayDetails();

        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ================= SEARCH BY NAME =================

    public void searchByName() {

        System.out.println("\n========== SEARCH BY NAME ==========");

        String name = readNonEmptyString("Enter Name: ");

        boolean found = false;

        for (Student student : students) {

            if (student.getName().toLowerCase()
                    .contains(name.toLowerCase())) {

                student.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found.");
        }
    }

    // ================= SEARCH BY COURSE =================

    public void searchByCourse() {

        System.out.println("\n========== SEARCH BY COURSE ==========");

        String courseName = readNonEmptyString("Enter Course: ");

        Course course = findCourse(courseName);

        if (course == null || course.getStudents().isEmpty()) {
            System.out.println("No student found for this course.");
            return;
        }

        for (Student student : course.getStudents()) {
            student.displayDetails();
        }
    }

    // ================= UPDATE =================

    @Override
    public void updateStudent() {

        System.out.println("\n========== UPDATE STUDENT ==========");

        String id = readNonEmptyString("Enter Student ID: ");

        Student student = studentMap.get(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nCurrent Details:");
        student.displayDetails();

        String updateChoice = "";
        while (!updateChoice.equalsIgnoreCase("done")) {
            updateChoice = readNonEmptyString(
                    "Enter what to update (Name, Course, Age, GPA) or 'Done' to finish: "
            );
            switch (updateChoice.toLowerCase()) {
                case "name":
                    String name = readNonEmptyString("Enter New Name: ");
                    if (name.equals(student.getName())) {
                        System.out.println("Name is the same as the current name.");
                    }
                    student.setName(name);
                    break;
                case "course":
                    String courseName = readNonEmptyString("Enter New Course: ");
                    for (Course course : student.getCourses()) {
                        if (course.getCourseName().equalsIgnoreCase(courseName)) {
                            System.out.println("Student is already enrolled in this course.");
                            break;
                        }
                    }
                    addStudentToCourse(student, courseName);
                    break;
                case "age":
                    int age = readInt("Enter New Age: ");
                    if (age < 5 || age > 100) {
                        System.out.println("Invalid age.");
                    } else if (age == student.getAge()) {
                        System.out.println("Age is the same as the current age.");
                    } else {
                        student.setAge(age);
                    }
                    break;
                case "gpa":
                    double GPA = readDouble("Enter New GPA: ");
                    if (GPA < 0 || GPA > 5) {
                        System.out.println("Invalid GPA.");
                    } else if (GPA == student.getGPA()) {
                        System.out.println("GPA is the same as the current GPA.");
                    } else {
                        student.setGPA(GPA);
                    }
                    break;
                case "done":
                    break;
                default:
                    System.out.println("Invalid choice. Please select Name, Course, Age, GPA, or Done.");
            }
        }

        System.out.println("\nStudent updated successfully!");

        saveToFile();
    }

    // ================= DELETE =================

    @Override
    public void deleteStudent() {

        System.out.println("\n========== DELETE STUDENT ==========");

        String id = readNonEmptyString("Enter Student ID: ");

        Student student = studentMap.get(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        student.displayDetails();

        System.out.print("Are you sure you want to delete? (Yes/No): ");

        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("Yes")) {

            students.remove(student);
            studentMap.remove(id);

            rebuildCourses();

            System.out.println("Student deleted successfully!");

            saveToFile();

        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    // ================= STATISTICS =================

    public void displayStatistics() {

        System.out.println("\n========== STUDENT STATISTICS ==========");

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).getGPA();
        double lowest = students.get(0).getGPA();

        int passed = 0;
        int failed = 0;

        for (Student student : students) {

            double GPA = student.getGPA();

            total += GPA;

            if (GPA > highest) {
                highest = GPA;
            }

            if (GPA < lowest) {
                lowest = GPA;
            }

            if (GPA >= 2.5) {
                passed++;
            } else {
                failed++;
            }
        }

        double average = total / students.size();

        System.out.println("Total Students : " + students.size());
        System.out.printf("Average GPA  : %.2f%n", average);
        System.out.printf("Highest GPA  : %.2f%n", highest);
        System.out.printf("Lowest GPA   : %.2f%n", lowest);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);
        System.out.println("Unique Courses : " + courses.size());
    }

    // ================= TOP STUDENTS =================

    public void displayTopStudents() {

        System.out.println("\n========== TOP PERFORMERS ==========");

        if (students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        ArrayList<Student> sorted = new ArrayList<>(students);

        sorted.sort(
                Comparator.comparingDouble(Student::getGPA)
                        .reversed()
        );

        int count = Math.min(5, sorted.size());

        for (int i = 0; i < count; i++) {

            Student student = sorted.get(i);

            System.out.println(
                    (i + 1) + ". "
                            + student.getName()
                            + " | "
                            + student.getStudentId()
                            + " | GPA: "
                            + student.getGPA()
                            + " | Grade: "
                            + student.getGrade()
            );
        }
    }

    // ================= SORT =================

    public void sortStudents() {

        System.out.println("\n========== SORT STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        System.out.println("1. GPA - Highest to Lowest");
        System.out.println("2. GPA - Lowest to Highest");
        System.out.println("3. Name - A to Z");
        System.out.println("4. Student ID");

        int choice = readInt("Enter choice: ");

        switch (choice) {

            case 1:
                students.sort(
                        Comparator.comparingDouble(Student::getGPA)
                                .reversed()
                );
                break;

            case 2:
                students.sort(
                        Comparator.comparingDouble(Student::getGPA)
                );
                break;

            case 3:
                students.sort(
                        Comparator.comparing(
                                Student::getName,
                                String.CASE_INSENSITIVE_ORDER
                        )
                );
                break;

            case 4:
                students.sort(
                        Comparator.comparing(Student::getStudentId)
                );
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Students sorted successfully.");

        viewStudents();
    }

    // ================= COURSE STATISTICS =================

    public void courseStatistics() {

        System.out.println("\n========== COURSE STATISTICS ==========");

        if (students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        for (Course course : courses) {
            System.out.println(course);
        }
        System.out.println("Total Courses: " + courses.size());

    }

    // ================= SAVE FILE =================

    public synchronized void saveToFile() {

        try {

            File directory = new File("data");

            if (!directory.exists()) {
                directory.mkdirs();
            }

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME)
                    );

            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error while saving data: "
                            + e.getMessage()
            );
        }
    }

    // ================= LOAD FILE =================

    private void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 5) {

                    String id = data[0];
                    String name = data[1];
                    int age = Integer.parseInt(data[3]);
                    double GPA = Double.parseDouble(data[4]);

                    Student student =
                            new Student(
                                    id,
                                    name,
                                    age,
                                    GPA
                            );

                    if (!data[2].isBlank()) {
                        for (String courseName : data[2].split(",")) {
                            addStudentToCourse(student, courseName.trim());
                        }
                    }

                    students.add(student);
                    studentMap.put(id, student);
                }
            }

            reader.close();

            System.out.println(
                    students.size()
                            + " student records loaded."
            );

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error while loading data."
            );
        }
    }

    // ================= REBUILD COURSES =================

    private void rebuildCourses() {

        for (Course course : courses) {
            course.clearStudents();
        }
        courses.clear();

        for (Student student : students) {
            for (Course course : student.getCourses()) {
                courses.add(course);
                course.addStudent(student);
            }
        }
    }

    // ================= INPUT METHODS =================

    private String readNonEmptyString(String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty. Try again."
            );
        }
    }

    private int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}