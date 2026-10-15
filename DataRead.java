package StudentInformationSystem;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class DataRead {
    static LinkedList<Student> students=new LinkedList<>();

    public static LinkedList<Student> read () throws IOException, CsvValidationException {
        students=new LinkedList<>();
        FileReader fileReader=new FileReader("Data/Student dataset.csv");
        CSVReader csvReader=new CSVReaderBuilder(fileReader).withSkipLines(1).build();

        String [] str;
        while ((str=csvReader.readNext())!=null) {
            students.add(new Student(
                    Integer.parseInt(str[0]),
                    str[1],
                    Integer.parseInt(str[2]),
                    Integer.parseInt(str[3]),
                    Float.parseFloat(str[4]),
                    Integer.parseInt(str[5]),
                    Integer.parseInt(str[6]),
                    Integer.parseInt(str[7]),
                    Integer.parseInt(str[8]),
                    Integer.parseInt(str[9]),
                    Integer.parseInt(str[10]),
                    Float.parseFloat(str[11])
            ));
        }

        fileReader.close();
        csvReader.close();
        return students;


    }

}
