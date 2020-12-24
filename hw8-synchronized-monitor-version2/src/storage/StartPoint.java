package storage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StartPoint {

    public static void main(String[] args) {

        clearFiles("data/copyAboutMonitor.txt");
        clearFiles("data/aboutMonitorByWord.txt");

        LineStorage lineStorage = new LineStorage();

        ContentReaderProducer producer = new ContentReaderProducer(lineStorage);
        ContentPrinterFirstConsumer firstConsumer = new ContentPrinterFirstConsumer(lineStorage);
        WordPrinterSecondConsumer secondConsumer = new WordPrinterSecondConsumer(lineStorage);

        new Thread(producer, "Producer").start();
        new Thread(firstConsumer, "First Consumer").start();
        new Thread(secondConsumer, "Second Consumer").start();
    }


    public static void clearFiles(String file) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            printWriter.print("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
