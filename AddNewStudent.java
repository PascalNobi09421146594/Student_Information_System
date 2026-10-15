package StudentInformationSystem;

import java.io.IOException;
import java.util.LinkedList;

public class AddNewStudent {
    LinkedList <Student> students;
    UserValidation userValidation = new UserValidation();
    DataWrite dataWrite = new DataWrite();
    CheckStudentID searchStudentID=new CheckStudentID();

    public AddNewStudent(LinkedList<Student> students) {
        this.students = students;
    }

    public void add() throws IOException {
        int id = userValidation.getStudentid();

        int index = searchStudentID.searchId(students, id);
        while (index >= 0) {
            System.out.println("ID " + "'" + id + "'" + " already exists");
            id = userValidation.getStudentid();
            index = searchStudentID.searchId(students, id);
        }

        String Name=userValidation.getName();
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

        students.add(new Student(id,Name,Age,Gender,StudyTime,Absences,Tutoring,Extracurricular,Sports,Music,Volunteering,GPA));

        dataWrite.writeToFile(students,"Data/Student dataset.csv");

        System.out.println("\nStudent Information Is Successfully Added!");
        System.out.println("Updated Student Dataset File Size: " + students.size());
    }



}