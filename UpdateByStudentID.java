package StudentInformationSystem;

import java.io.IOException;
import java.util.LinkedList;

public class UpdateByStudentID {
    LinkedList<Student> students;
    UserValidation userValidation = new UserValidation();
    DataWrite writeToCSV = new DataWrite();
    CheckStudentID searchStudentID = new CheckStudentID();

    public UpdateByStudentID(LinkedList<Student> students) {
        this.students = students;
    }

    public void update() throws IOException {
        int id = userValidation.getStudentid();
        int index = searchStudentID.searchId(students, id);

        while (index < 0) {
            System.err.println("'" + id + "'" + " doesn't exist");
            id = userValidation.getStudentid();
            index = searchStudentID.searchId(students, id);
        }

        String Name = userValidation.getName();
        int Age = userValidation.getAge();
        int Gender = userValidation.getGender();
        float StudyTime = userValidation.getStudyTime();
        int Absences = userValidation.getAbsences();
        int Tutoring = userValidation.getTutoring();
        int Extracurricular = userValidation.getExtracurricular();
        int Sports = userValidation.getSports();
        int Music = userValidation.getMusic();
        int Volunteering = userValidation.getVolunteering();
        float GPA = userValidation.getGPA();

        Student student = students.get(index);

        students.set(index,new Student(id, Name, Age, Gender, StudyTime, Absences, Tutoring, Extracurricular, Sports, Music, Volunteering, GPA));

        writeToCSV.writeToFile(students, "Data/Student dataset.csv");

        System.out.println("\nStudent Information Is Successfully Updated!");


    }
}
