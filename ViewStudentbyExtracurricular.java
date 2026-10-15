package StudentInformationSystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ViewStudentbyExtracurricular {
    LinkedList<Student> students;

    public ViewStudentbyExtracurricular(LinkedList<Student> students) {
        this.students = students;
    }

    public void studentByExtracurricularType() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter extracurricular type (Yes/No): ");
        String input = sc.nextLine().trim().toUpperCase();

        boolean ansValue;
        if (input.equals("YES")) {
            ansValue = true;
        } else if (input.equals("NO")) {
            ansValue = false;
        } else {
            System.out.println("❌ Invalid input. Please enter Yes or No.");
            return;
        }

        int count = 0;

        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new CWC_LongestWord());
        table.addRule();
        table.addRow(Arrays.asList("Student ID", "Name", "Age", "Gender", "GPA", "Extracurricular"));
        table.addRule();

        for (Student student : students) {
            boolean extracurricular = student.getExtracurricular() == 1 ? true : false;
            if (extracurricular == ansValue) {
                String genderDisplay = student.getGender() == 0 ? "Male"
                        : student.getGender() == 1 ? "Female" : String.valueOf(student.getGender());
                String extraDisplay = extracurricular ? "Yes" : "No";

                table.addRow(
                        student.getStudentid(),
                        student.getName(),
                        student.getAge(),
                        genderDisplay,
                        student.getGPA(),
                        extraDisplay
                );
                table.addRule();
                count++;
            }
        }

        System.out.println("\n🎓 Students with Extracurricular = " + input.toUpperCase());
        System.out.println(table.render());
        System.out.println("📊 Total Students in this category: " + count);


    }
}
