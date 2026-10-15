package StudentInformationSystem;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentMain extends StudentADT{
    Scanner sc=new Scanner(System.in);
    LinkedList<Student> students;

    public void menu(){
        System.out.println("***** Student Performance System *****");
        System.out.println("1. Add New Student Data");
        System.out.println("2. Update Student Data");
        System.out.println("3. Delete Student Data");
        System.out.println("4. View Number of Absences Per Student");
        System.out.println("5. View sorted student By GPA");
        System.out.println("6. View Student in Specific Activites");
        System.out.println("7. View Student in the grade class");
        System.out.println("8. Search Student Data By Student ID");
        System.out.println("9. View Student by Extracurricular");
        System.out.println("10. View sorted Student Study Time Per Student");
        System.out.println("11. Exit\n");

        System.out.println("Choose menu number between 1 to 11");


    }

    // check the user input number is between 1 and 8
    public String getMenuNumber() {
        String num = sc.nextLine();

        if(!num.matches("^(1[0-1]|[1-9])$")) {
            System.out.println("Menu number must be 1 to 11!");
            num = getMenuNumber();
        }
        return num;
    }

    // Display different information based on user input
    public void displayMenu() throws IOException, CsvValidationException {
        System.out.println();
        menu();
        switch (getMenuNumber()) {
            case "1":{
                addStudent();
                displayMenu();
                break;
            }
            case "2":{
                updateStudent();
                displayMenu();
                break;
            }

            case "3":{
                deleteStudent();
                displayMenu();
                break;
            }

          case "4":{
                Numofabsences();
                displayMenu();
               break;
           }

            case "5":{
                NumStudentByGPA();
                displayMenu();
                break;
            }

            case "6":{
                viewStudentInActivities();
                displayMenu();
                break;
            }

            case "7":{
                NumOfStudentinGradeClass();
                displayMenu();
                break;
            }

            case "8": {
                searchStudentDataByID();
                displayMenu();
                break;
            }

            case "9": {
                viewStudentByExtracurricular();
                displayMenu();
                break;
            }

            case "10": {
                sortedStudentStudyTimePerStudent();
                displayMenu();
                break;
            }

            case "11": {
                System.out.println("Thank You!");
                System.exit(0);
            }
        }
    }






    @Override
    void addStudent() throws CsvValidationException, IOException {
        students=new LinkedList<>();
        students=DataRead.read();
        System.out.println("Student Dataset File Size "+ students.size());

        AddNewStudent addNewStudent=new AddNewStudent(students);
        addNewStudent.add();


    }

    @Override
    void updateStudent() throws CsvValidationException, IOException {
        students=new LinkedList<>();
        students=DataRead.read();
        System.out.println("Student Dataset File Size "+ students.size());

        UpdateByStudentID updtaeByStudentID=new UpdateByStudentID(students);
        updtaeByStudentID.update();
    }

    @Override
    void deleteStudent() throws CsvValidationException, IOException {
        students = new LinkedList<>();
        students = DataRead.read();

        DeleteByStudentID deleteByStudentId = new DeleteByStudentID(students);
        deleteByStudentId.delete();
    }

    @Override
    void Numofabsences() throws CsvValidationException, IOException {
       students = new LinkedList<>();
      students = DataRead.read();

        AbsencesByStudent numberOfAbsence = new AbsencesByStudent(students);
        numberOfAbsence.showAbsenceReport();
    }

    @Override
    void NumStudentByGPA() throws CsvValidationException, IOException {
        students = new LinkedList<>();
        students = DataRead.read();

        ViewNumOfStudentByGPA viewNumOfStudentByGPA = new ViewNumOfStudentByGPA(students);
        viewNumOfStudentByGPA.viewSortStudentByGPA();
    }

    @Override
    void viewStudentInActivities() throws CsvValidationException, IOException {
        students = new LinkedList<>();
        students = DataRead.read();

        StudentInActivities studentInActivities = new StudentInActivities(students);
        studentInActivities.viewStudentInActivites();
    }

    @Override
    void NumOfStudentinGradeClass() throws CsvValidationException, IOException {
        students = new LinkedList<>();
        students = DataRead.read();

        ViewStudentInGradeClass viewStudentInGradeClass = new ViewStudentInGradeClass(students);
        viewStudentInGradeClass.showGradeReportByInput();
    }

    @Override
    void searchStudentDataByID() throws CsvValidationException, IOException {
        students = new LinkedList<>();
        students = DataRead.read();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to search: ");
        String input = sc.nextLine().trim();

        // 1. Validate if input is an integer
        if (!input.matches("\\d+")) {
            System.out.println("❌ Invalid ID format. Please enter a numeric ID.");
            return;
        }

        // 2. Proceed with search
        int ID = Integer.parseInt(input);

        SearchStudentDataByStudentId searchStudentDataByStudentId = new SearchStudentDataByStudentId(students);
        searchStudentDataByStudentId.searchAndShowRecord(ID);
    }

    @Override
    void viewStudentByExtracurricular() throws CsvValidationException, IOException {
        students = new LinkedList<>();
        students = DataRead.read();

        ViewStudentbyExtracurricular viewStudentbyExtracurricular=new ViewStudentbyExtracurricular(students);
        viewStudentbyExtracurricular.studentByExtracurricularType();
    }

    @Override
    void sortedStudentStudyTimePerStudent() throws CsvValidationException, IOException {
        students = new LinkedList<>();
        students = DataRead.read();

        ViewStudyTimePerStudent viewStudyTimePerStudent=new ViewStudyTimePerStudent(students);
        viewStudyTimePerStudent.viewSortStudentByGPA();
    }

    public static void main(String[] args) throws CsvValidationException, IOException {
        System.out.println("Loading...");
        StudentMain main = new StudentMain();
        main.displayMenu();
    }
}


