import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String studentId;
    private String name;
    private String phone;
    private String marks;

    // Constructor
    public Contact(String name, String phone, String studentId, String marks) {
        this.name = name;
        this.phone = phone;
        this.studentId = studentId;
        this.marks = marks;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getMarks() { return marks; }
    public void setMarks(String marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "Name: " + name +
                " | Phone: " + phone +
                " | StudentID: " + studentId +
                " | Marks: " + marks;
    }
}

public class Main {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n====== Student Record Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("👋 Exiting... Thank you!");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    // Add student
    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter StudentID: ");
        String studentId = sc.nextLine();
        System.out.print("Enter Student Marks: ");
        String marks = sc.nextLine();

        contacts.add(new Contact(name, phone, studentId, marks));
        System.out.println("✅ Student added successfully!");
    }

    // View students
    private static void viewStudent() {
        if (contacts.isEmpty()) {
            System.out.println("⚠️ No students found!");
        } else {
            System.out.println("\n------ Student List ------");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    // Update student
    private static void updateStudent() {
        viewStudent();
        if (contacts.isEmpty()) return;

        System.out.print("\nEnter student number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // consume newline

        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);

            System.out.print("Enter new name (" + contact.getName() + "): ");
            String name = sc.nextLine();
            System.out.print("Enter new phone (" + contact.getPhone() + "): ");
            String phone = sc.nextLine();
            System.out.print("Enter new studentId (" + contact.getStudentId() + "): ");
            String studentId = sc.nextLine();
            System.out.print("Enter new marks (" + contact.getMarks() + "): ");
            String marks = sc.nextLine();

            if (!name.isEmpty()) contact.setName(name);
            if (!phone.isEmpty()) contact.setPhone(phone);
            if (!studentId.isEmpty()) contact.setStudentId(studentId);
            if (!marks.isEmpty()) contact.setMarks(marks);

            System.out.println("✅ Student updated successfully!");
        } else {
            System.out.println("❌ Invalid student number!");
        }
    }

    // Delete student BY STUDENT ID
    private static void deleteStudent() {
        viewStudent();
        if (contacts.isEmpty()) return;

        System.out.print("\nEnter Student ID to delete: ");
        String studentId = sc.nextLine();

        boolean removed = contacts.removeIf(c -> c.getStudentId().equals(studentId));

        if (removed) {
            System.out.println("🗑️ Student deleted successfully!");
        } else {
            System.out.println("❌ Student ID not found!");
        }
    }
}
