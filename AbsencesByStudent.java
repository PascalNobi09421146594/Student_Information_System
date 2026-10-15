package StudentInformationSystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.LinkedList;

public class AbsencesByStudent {
    LinkedList<Student> students;

    public AbsencesByStudent(LinkedList<Student> students) {
        this.students = students;
    }


    public void showAbsenceReport() {
        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new CWC_LongestWord());

        table.addRule();
        table.addRow(Arrays.asList("Student ID", "Student Name", "Number of Absences"));
        table.addRule();

        for (Student student : students) {
            table.addRow(
                    student.getStudentid(),
                    student.getName(),
                    student.getAbsences()
            );
            table.addRule();
        }

        System.out.println("\n--- Number of Absences per Student Report ---");
        System.out.println(table.render());
    }
}
