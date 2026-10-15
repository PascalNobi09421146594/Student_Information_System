package StudentInformationSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserValidation {

    Scanner sc=new Scanner(System.in);

    public int getStudentid(){
        try {
            System.out.println("Enter Student ID:");
            int input = sc.nextInt();
            sc.nextLine();

            if (input <= 0) {
                System.out.println("Student ID must be greater than 0. Try again!");
                return getStudentid();
            }

            return input;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Student ID must be a number. Try again!");
            return getStudentid();
        }
    }

    public String getName() {
        System.out.println("Enter Student Name");
        String input = sc.nextLine();

        if(!input.matches("^[A-Za-z][A-Za-z \\-]{0,49}$")) {
            System.err.println("Name Format Is Wrong. Please Try Again!");
            input = getName();
        }

        return input;
    }


    public int getAge() {
        try {
            System.out.println("Enter Student Age:");
            int input = sc.nextInt();
            sc.nextLine();

            if (input < 13 || input > 100) {
                System.out.println("Age must be between 13 and 100. Try again!");
                return getAge();
            }

            return input;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Age must be a number. Try again!");
            return getAge();
        }
    }

    public int getGender() {
        System.out.println("Enter gender");
        int input=sc.nextInt();
        if (input>0 && input < 1){
            System.out.println("Gender must be 0 or 1");
            input=getGender();
        }
        return input;
    }

    public float getStudyTime() {
        System.out.println("Enter Study Time");
        float input=sc.nextFloat();
        if (input<0){
            System.out.println("Study Time must be greater than 0");
            input=getStudyTime();
        }
        return input;
    }

    public int getAbsences() {
        try {
            System.out.println("Enter Number of Absences (0–45):");
            int input = sc.nextInt();
            sc.nextLine();

            if (input < 0 || input > 45) {
                System.out.println("Absences must be between 0 and 45. Try again!");
                return getAbsences();
            }

            return input;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Absences must be a number. Try again!");
            return getAbsences();
        }
    }

    public int getTutoring() {
        System.out.println("Enter Student take tutoring or not answer with 0 or 1");
        int input=sc.nextInt();

        if (input < 0 && input > 1){
            System.out.println("Student's tutoring Experience must be 0 or 1");
            input=getTutoring();
        }
        return input;

    }


    public int getExtracurricular() {
        System.out.println("Enter Student Extracurricular 0 or 1");
        int input=sc.nextInt();

        if (input < 0 && input > 1){
            System.out.println("Student's Extracurricular Experience must be 0 or 1");
            input=getExtracurricular();
        }
        return input;
    }

    public int getSports() {
        System.out.println("Enter Student Sport Experience 0 or 1");
        int input=sc.nextInt();

        if (input < 0 && input > 1){
            System.out.println("Student's Sport Experience must be 0 or 1");
            input=getSports();
        }
        return input;
    }

    public int getMusic() {
        System.out.println("Enter Student Music Experience 0 or 1");
        int input=sc.nextInt();

        if (input < 0 && input > 1){
            System.out.println("Student's Music Experience must be 0 or 1");
            input=getMusic();
        }
        return input;
    }

    public int getVolunteering() {
        System.out.println("Enter Student Volunteering Experience 0 or 1");
        int input=sc.nextInt();

        if (input < 0 && input > 1){
            System.out.println("Student's Volunteering Experience must be 0 or 1");
            input=getVolunteering();
        }
        return input;
    }

    public float getGPA() {
        float input = -1;

        while (true) {
            try {
                System.out.print("Enter Valid Student GPA (0.0 to 4.0): ");
                input = sc.nextFloat();

                if (input >= 0 && input <= 4) {
                    break;
                } else {
                    System.out.println("Error: GPA must be between 0 and 4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a numeric value (e.g., 3.5).");
                sc.nextLine();
            }
        }

        return input;
    }



}


