import java.util.*;

class Student {
    String name;
    double marks;
    double familyIncome;
    boolean isEligible;

    Student(String name, double marks, double familyIncome) {
        this.name = name;
        this.marks = marks;
        this.familyIncome = familyIncome;
        this.isEligible = false;
    }

    void checkEligibility() {
        // Example criteria:
        // Marks >= 75 AND Income <= 250000
        if (marks >= 75 && familyIncome <= 250000) {
            isEligible = true;
        } else {
            isEligible = false;
        }
    }
}

public class ScholarshipSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Marks: ");
            double marks = sc.nextDouble();

            System.out.print("Family Income: ");
            double income = sc.nextDouble();
            sc.nextLine();

            Student s = new Student(name, marks, income);
            s.checkEligibility();
            students.add(s);
        }

        // Display eligible students
        System.out.println("\nEligible Students:");
        for (Student s : students) {
            if (s.isEligible) {
                System.out.println(s.name + " | Marks: " + s.marks);
            }
        }

        // Shortlisting (Top 3 based on marks)
        students.sort((a, b) -> Double.compare(b.marks, a.marks));

        System.out.println("\nShortlisted Students (Top 3):");
        int count = 0;
        for (Student s : students) {
            if (s.isEligible && count < 3) {
                System.out.println(s.name + " | Marks: " + s.marks);
                count++;
            }
        }

        sc.close();
    }
}
