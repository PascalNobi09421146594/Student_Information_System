package StudentInformationSystem;


import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;
import java.util.stream.Collectors;

public class StudentInActivities {
    LinkedList<Student> students;
    UserValidation userValidation = new UserValidation();
    private Scanner sc = new Scanner(System.in);

    public StudentInActivities(LinkedList<Student> students) {
        this.students = students;

    }

    public void viewStudentInActivites() {

        System.out.print("Enter activity to search (music, sports, volunteering): ");
        String activity = sc.nextLine().trim().toLowerCase();

        while (!activity.equals("music") && !activity.equals("sports") && !activity.equals("volunteering")) {
            System.out.print("Invalid input. Please enter 'music', 'sports', or 'volunteering': ");
            activity = sc.nextLine().trim().toLowerCase();
        }

        List<Student> filteredStudents = new ArrayList<>();

        switch (activity) {
            case "music":
                filteredStudents = students.stream()
                        .filter(s -> s.getMusic() == 1)
                        .collect(Collectors.toList());
                break;

            case "sports":
                filteredStudents = students.stream()
                        .filter(s -> s.getSports() == 1)
                        .collect(Collectors.toList());
                break;

            case "volunteering":
                filteredStudents = students.stream()
                        .filter(s -> s.getVolunteering() == 1)
                        .collect(Collectors.toList());
                break;
        }


        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new de.vandermeer.asciitable.CWC_LongestWord());

        table.addRule();
        table.addRow("Student Name", "Student ID", "Activity");
        table.addRule();

        for (Student student : filteredStudents) {
            table.addRow(student.getName(), student.getStudentid(), capitalize(activity));
            table.addRule();
        }

        if (filteredStudents.isEmpty()) {
            System.out.println("No students found participating in " + activity + ".");
        } else {
            System.out.println(table.render());
            System.out.println("✅ Total number of students in " + capitalize(activity) + ": " + filteredStudents.size());
        }
    }

    private String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }


}
