
import java.io.*;
import java.util.*;

class Student implements Serializable {

    private int studentId;
    private String name;
    private int rollNo;
    private String studentClass;
    private double marks;
    private String address;

    public Student(int studentId, String name, int rollNo, String studentClass, double marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.studentClass = studentClass;
        this.marks = marks;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Roll No: " + rollNo + ", Class: " + studentClass + ", Marks: " + marks + ", Address: " + address;
    }
}

public class StudentDatabase {

    private static final String FILE_NAME = "student_database.ser";

    public static void createDatabase(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Database created successfully.");
        } catch (IOException e) {
            System.out.println("Error while creating the database: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Student> readDatabase() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while reading the database: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void displayDatabase() {
        List<Student> students = readDatabase();
        if (students.isEmpty()) {
            System.out.println("No records found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    public static void clearRecords() {
        createDatabase(new ArrayList<>());
        System.out.println("All records cleared.");
    }

    public static void modifyRecord(int studentId) {
        List<Student> students = readDatabase();
        boolean found = false;
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                found = true;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new name: ");
                student.setName(scanner.nextLine());
                System.out.println("Enter new roll number: ");
                student.setRollNo(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Enter new class: ");
                student.setStudentClass(scanner.nextLine());
                System.out.println("Enter new marks: ");
                student.setMarks(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Enter new address: ");
                student.setAddress(scanner.nextLine());
                break;
            }
        }
        if (found) {
            createDatabase(students);
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public static void searchRecord(int studentId) {
        List<Student> students = readDatabase();
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Create Database\n2. Display Database\n3. Clear Records\n4. Modify Record\n5. Search Record\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Student> students = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Enter details for student " + (i + 1) + ":");
                        System.out.print("Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Roll No: ");
                        int rollNo = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Class: ");
                        String studentClass = scanner.nextLine();
                        System.out.print("Marks: ");
                        double marks = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Address: ");
                        String address = scanner.nextLine();

                        students.add(new Student(id, name, rollNo, studentClass, marks, address));
                    }
                    createDatabase(students);
                    break;
                case 2:
                    displayDatabase();
                    break;
                case 3:
                    clearRecords();
                    break;
                case 4:
                    System.out.print("Enter Student ID to modify: ");
                    int modifyId = scanner.nextInt();
                    modifyRecord(modifyId);
                    break;
                case 5:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    searchRecord(searchId);
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
