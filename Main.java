import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("\n1. Add Student  2. Display Students  3. Average Grade  4. Exit\nChoose: ");
            switch (scanner.nextInt()) {
                case 1 -> addStudent();
                case 2 -> students.forEach(s -> System.out.println(s));
                case 3 -> System.out.println("Average Grade: " +
                        students.stream().mapToDouble(Student::getGrade).average().orElse(0));
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter grade: ");
        students.add(new Student(name, scanner.nextDouble()));
    }
}

class Student {
    private final String name;
    private final double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + grade;
    }
}
