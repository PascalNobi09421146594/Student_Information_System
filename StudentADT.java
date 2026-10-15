package StudentInformationSystem;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public abstract class StudentADT {
    abstract void addStudent() throws CsvValidationException, IOException;
    abstract void updateStudent() throws CsvValidationException, IOException;
    abstract void deleteStudent() throws CsvValidationException, IOException;
    abstract void Numofabsences() throws CsvValidationException, IOException;
    abstract void NumStudentByGPA() throws CsvValidationException, IOException;
    abstract void viewStudentInActivities() throws CsvValidationException, IOException;
    abstract void NumOfStudentinGradeClass() throws CsvValidationException, IOException;
    abstract void searchStudentDataByID() throws CsvValidationException, IOException;
    abstract void viewStudentByExtracurricular() throws CsvValidationException, IOException;
    abstract void sortedStudentStudyTimePerStudent() throws CsvValidationException, IOException;
}
