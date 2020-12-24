package storage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StartPoint {

    public static void main(String[] args) {

        clearFiles("data/copyAboutMonitor.txt");
        clearFiles("data/aboutMonitorByWord.txt");

        LineStorage lineStorage = new LineStorage();

        ContentReader contentReader = new ContentReader(lineStorage);
        ContentPrinter contentPrinter = new ContentPrinter(lineStorage);

        Thread producer = new Thread(contentReader,"Reader");
        producer.start();

        Thread consumer = new Thread(contentPrinter,"Printer");
        consumer.start();
    }


    public static void clearFiles(String file) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            printWriter.print("");

            // or
//            printWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
