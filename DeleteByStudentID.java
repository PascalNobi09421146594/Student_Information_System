package StudentInformationSystem;

import java.io.IOException;
import java.util.LinkedList;

public class DeleteByStudentID {
    LinkedList<Student> students;
    UserValidation userValidation = new UserValidation();
    DataWrite writeToCSV = new DataWrite();
    CheckStudentID searchStudentId = new CheckStudentID();

    public DeleteByStudentID(LinkedList<Student> students) {
        this.students = students;
    }
    public void delete() throws IOException {
        int id = userValidation.getStudentid();
        int index = searchStudentId.searchId(students, id);

        while(index < 0) {
            System.err.println("'" + id + "'" + " doesn't exist to delete");
            id = userValidation.getStudentid();
            index = searchStudentId.searchId(students, id);




        }

        students.remove(index);

        writeToCSV.writeToFile(students, "Data/Student dataset.csv");

        System.out.println("\nStudent Information Is Successfully Deleted!");
        System.out.println("Updated Student Dataset File Size: " + students.size());
    }


}
