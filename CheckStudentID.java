package StudentInformationSystem;

import java.util.LinkedList;

public class CheckStudentID {

    // linear search
    public int searchId(LinkedList<Student> students, int id) {
        int index = 0;
        long startTime = System.currentTimeMillis();
        for (Student student : students) {
            if (student.getStudentid() == id) {
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("Search Duration: " + elapsedTime + " milliseconds");

                Runtime run = Runtime.getRuntime();
                run.gc();
                long memory = run.totalMemory() - run.freeMemory();
                System.out.println("Memory Consumption in Bytes: " + memory + " bytes!");
                System.out.println("Memory Consumption in Megabytes: " + bytesToMegabytes(memory) + " megabytes!");

                return index;
            }
            index++;
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Search Duration: " + elapsedTime + " milliseconds");

        Runtime run = Runtime.getRuntime();
        run.gc();
        long memory = run.totalMemory() - run.freeMemory();
        System.out.println("Memory Consumption in Bytes: " + memory + " bytes!");
        System.out.println("Memory Consumption in Megabytes: " + bytesToMegabytes(memory) + " megabytes!");

        return -1;
    }


    private static long megabytes = 1024L * 1024L;

    private static long bytesToMegabytes(long bytes) {
        return bytes / megabytes;
    }


}
