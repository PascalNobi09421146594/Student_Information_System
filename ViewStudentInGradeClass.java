package StudentInformationSystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ViewStudentInGradeClass {
    LinkedList<Student> students;

    public ViewStudentInGradeClass(LinkedList<Student> students) {

        this.students = students;
    }

    public void showGradeReportByInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter grade to search (A/B/C/D): ");
        String gradeInput = sc.nextLine().toUpperCase().trim();

        if (!gradeInput.matches("[ABCD]")) {
            System.out.println("❌ Invalid input. Please enter A, B, C, or D.");
            return;
        }

        // Count matching students
        int count = 0;
        for (Student student : students) {
            if (getGradeFromGpa(student.getGPA()).equals(gradeInput)) {
                count++;
            }
        }

        System.out.println("\n🔎 Total students with grade " + gradeInput + ": " + count);

        if (count == 0) {
            System.out.println("📭 No students found with that grade.");
            return;
        }

        // Display matching students
        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new de.vandermeer.asciitable.CWC_LongestWord());
        table.addRule();
        table.addRow(Arrays.asList("Student ID", "Name", "GPA", "Grade"));
        table.addRule();

        for (Student student : students) {
            String grade = getGradeFromGpa(student.getGPA());
            if (grade.equals(gradeInput)) {
                table.addRow(student.getStudentid(), student.getName(), String.format("%.2f", student.getGPA()), grade);
                table.addRule();
            }
        }

        System.out.println("\n🎓 Students with Grade " + gradeInput + ":");
        System.out.println(table.render());
    }

    // GPA to grade mapping
    private String getGradeFromGpa(double gpa) {
        if (gpa <= 1.0) return "D";
        else if (gpa <= 2.0) return "C";
        else if (gpa <= 3.0) return "B";
        else return "A";
    }
}
