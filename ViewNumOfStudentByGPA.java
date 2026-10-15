package StudentInformationSystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class ViewNumOfStudentByGPA {
    LinkedList<Student> students;

    public ViewNumOfStudentByGPA(LinkedList<Student> students) {
        this.students = students;
    }

    private LinkedList<Student> sortByGPA() {
        LinkedList<Student> sortedGPA = sortedStudent(students);
        return sortedGPA;
    }


    private LinkedList<Student> sortedStudent(LinkedList<Student> students) {
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
            while (leftptr <= right && Double.compare(studentList.get(leftptr).getGPA(), pivot.getGPA()) > 0) {
                leftptr++;
            }

            while (rightptr >= left && Double.compare(studentList.get(rightptr).getGPA(), pivot.getGPA()) < 0) {
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
        LinkedList<Student> students = sortByGPA();
        if (students.isEmpty()) {
            System.out.println("📭 No student data available.");
            return;
        }

        Map<Double, Integer> gpaCount = new TreeMap<>(Comparator.reverseOrder());

        for (Student student : students) {
            double roundedGpa = Math.round(student.getGPA() * 100.0) / 100.0;
            gpaCount.put(roundedGpa, gpaCount.getOrDefault(roundedGpa, 0) + 1);
        }

        AsciiTable table = new AsciiTable();
        table.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new CWC_LongestWord());

        table.addRule();
        table.addRow(Arrays.asList("Student Name", "GPA"));
        table.addRule();

        long startTime = System.currentTimeMillis();
        for (Student student : students) {
            table.addRow(
                    student.getName(),
                    student.getGPA()
            );
            table.addRule();
        }

        System.out.println("\n--- Sorted Student by GPA Report ---");
        System.out.println(table.render());

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quick Sort Duration: " + elapsedTime + " milliseconds");

        System.out.println();

        Runtime run = Runtime.getRuntime();
        run.gc();

        long memory = run.totalMemory() - run.freeMemory();
        System.out.println("Memory Consumption in Bytes: " + memory + " bytes!");
        System.out.println("Memory Consumption in Megabytes: " + bytesToMegabytes(memory) + " megabytes!");
    }


    private static long megabytes = 1024L * 1024L;

    private static long bytesToMegabytes(long bytes) {
        return bytes / megabytes;
    }
}
