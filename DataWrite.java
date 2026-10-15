package StudentInformationSystem;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class DataWrite {
    public void writeToFile(LinkedList<Student> students, String fileName) throws IOException {
        FileWriter fw = new FileWriter("Data/Student dataset.csv", false);
        CSVWriter cw = new CSVWriter(fw);

        String[] columnTitles = {
                "StudentID",
                "Name",
                "Age",
                "Gender",
                "StudyTime",
                "Absences",
                "Tutoring",
                "Extracurricular",
                "Sports",
                "Music",
                "Volunteering",
                "GPA",
        };
        cw.writeNext(columnTitles);

        for (Student student : students) {
            String[] str = {
                    String.valueOf(student.getStudentid()),
                    student.getName(),
                    String.valueOf(student.getAge()),
                    String.valueOf(student.getGender()),
                    String.valueOf(student.getStudyTime()),
                    String.valueOf(student.getAbsences()),
                    String.valueOf(student.getTutoring()),
                    String.valueOf(student.getExtracurricular()),
                    String.valueOf(student.getSports()),
                    String.valueOf(student.getMusic()),
                    String.valueOf(student.getVolunteering()),
                    String.valueOf(student.getGPA())

            };

            cw.writeNext(str);
        }

        cw.close();
        fw.close();
    }
}

