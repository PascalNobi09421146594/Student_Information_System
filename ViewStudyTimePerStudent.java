package StudentInformationSystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class ViewStudyTimePerStudent {
    LinkedList<Student> students;

    public ViewStudyTimePerStudent(LinkedList<Student> students) {
        this.students = students;
    }

    private LinkedList<Student> sortByStudyTimePerStudent() {
        LinkedList<Student> sortedStudyTime = sortedStudyTimePerStudent (students);
        return sortedStudyTime;
    }


    private LinkedList<Student> sortedStudyTimePerStudent (LinkedList<Student> students) {
        List<Student> studentList= new ArrayList<>(students);

        quickSort(studentList, 0, studentList.size() - 1);

        return new LinkedList<>(studentList);
    }

    // Quick sort
    private static void quickSort(List<Student> studentList, int left, int right) {
        if(right - left <= 0) {
            return;
        } else {
            Student pivot = studentList.get(left);
            int location = partition(studentList, left, right, pivot);
            quickSort(studentList, left, location - 1);
            quickSort(studentList, location + 1, right);
        }
    }

    // Divide partition for quick sort
    private static int partition(List<Student> studentList, int left, int right, Student pivot) {
        int leftptr = left + 1;
        int rightptr = right;

        while (true) {
            while (leftptr <= right && Double.compare(studentList.get(leftptr).getStudyTime(), pivot.getStudyTime()) > 0) {
                leftptr++;
            }

            while (rightptr >= left && Double.compare(studentList.get(rightptr).getStudyTime(), pivot.getStudyTime()) < 0) {
                rightptr--;
            }

            if (leftptr >= rightptr) {
                break;
            } else {
                Student temp = studentList.get(leftptr);
                studentList.set(leftptr, studentList.get(rightptr));
                studentList.set(rightptr, temp);
                leftptr++;
                rightptr--;
            }
        }

        Student temp = studentList.get(left);
        studentList.set(left,studentList.get(rightptr));
        studentList.set(rightptr, temp);

        return rightptr;
    }

    public void viewSortStudentByGPA() {
        LinkedList<Student> students = sortByStudyTimePerStudent();
        if (students.isEmpty()) {
            System.out.println("📭 No student data available.");
            return;
        }

        Map<Double, Integer> timeCount = new TreeMap<>(Comparator.reverseOrder());

        for (Student student : students) {
            double roundedGpa = Math.round(student.getGPA() * 100.0) / 100.0;
            timeCount.put(roundedGpa, timeCount.getOrDefault(roundedGpa, 0) + 1);
        }

        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new CWC_LongestWord());

        table.addRule();
        table.addRow(Arrays.asList("Student Name", "GPA"));
        table.addRule();

        for (Student student : students) {
            table.addRow(
                    student.getName(),
                    student.getStudyTime()
            );
            table.addRule();
        }

        System.out.println("\n--- Sorted Student by study time Report ---");
        System.out.println(table.render());

    }


}
