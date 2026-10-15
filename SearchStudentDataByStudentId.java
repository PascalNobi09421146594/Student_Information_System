package StudentInformationSystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.LinkedList;

public class SearchStudentDataByStudentId {
    LinkedList<Student> students;

    public SearchStudentDataByStudentId(LinkedList<Student> students) {
        this.students = students;
    }

    public void searchAndShowRecord(int searchId) {
        students.sort((a, b) -> Integer.compare(a.getStudentid(), b.getStudentid()));

        int index = binarySearchByID(searchId);

        if (index == -1) {
            System.out.println("❌ No student found with ID " + searchId);
            return;
        }

        Student student = students.get(index);


        String genderDisplay = student.getGender()== 0 ? "Male" :
                student.getGender() == 1 ? "Female" : String.valueOf(student.getGender());

        String tutoring = student.getTutoring() == 1 ? "Yes" : "No";
        String extracurricular = student.getExtracurricular() == 1 ? "Yes" : "No";
        String sports = student.getSports() == 1 ? "Yes" : "No";
        String music = student.getMusic() == 1 ? "Yes" : "No";
        String volunteering = student.getVolunteering() == 1 ? "Yes" : "No";

        // Display table
        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new CWC_LongestWord());
        table.addRule();

        table.addRow("Student ID", "Name", "Age", "Gender", "GPA",
                "Tutoring", "Extracurricular", "Sports", "Music", "Volunteering");
        table.addRule();

        table.addRow(
                student.getStudentid(),
                student.getName(),
                student.getAge(),
                genderDisplay,
                student.getGPA(),
                tutoring,
                extracurricular,
                sports,
                music,
                volunteering
        );

        table.addRule();

        System.out.println("\n✅ Student Record Found:");
        System.out.println(table.render());
    }

    private int binarySearchByID(int id) {
        int left = 0;
        int right = students.size() - 1;
        long startTime = System.currentTimeMillis();

        while (left <= right) {
            int mid = (left + right) / 2;
            int midId = students.get(mid).getStudentid();

            if (midId == id) {
                reportPerformance(startTime);
                return mid;
            } else if (midId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        reportPerformance(startTime);
        return -1;
    }

    private void reportPerformance(long startTime) {
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Search Duration: " + elapsedTime + " milliseconds");

        Runtime run = Runtime.getRuntime();
        run.gc();
        long memory = run.totalMemory() - run.freeMemory();
        System.out.println("Memory Consumption in Bytes: " + memory + " bytes");
        System.out.println("Memory Consumption in Megabytes: " + bytesToMegabytes(memory) + " MB");
        System.out.println();
    }

    private static long megabytes = 1024L * 1024L;

    private static long bytesToMegabytes(long bytes) {
        return bytes / megabytes;
    }
}
