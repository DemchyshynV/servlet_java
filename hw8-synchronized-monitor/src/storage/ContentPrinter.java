package storage;

import lombok.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ContentPrinter implements Runnable {

    private LineStorage lineStorage;

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/aboutMonitor.txt"))) {

            synchronized (this.lineStorage) {
                while ((bufferedReader.readLine()) != null) {
                    if (this.lineStorage.isPrinted()) {
                        try {
                            this.lineStorage.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + ": " + this.lineStorage.getTextOfLine());

                        rewriteFile(this.lineStorage.getTextOfLine());
                        wordWriter(this.lineStorage.getTextOfLine());

                        this.lineStorage.setPrinted(true);
                        this.lineStorage.notify();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteFile(String textLine) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("data/copyAboutMonitor.txt", true))) {
            printWriter.println(textLine);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wordWriter(String textLine) {
        List<String> listOfWordsInTextLine = new ArrayList<>(Arrays.asList(textLine.split(" ")));

        try (PrintWriter printWriter = new PrintWriter(new FileWriter("data/aboutMonitorByWord.txt", true))) {
            listOfWordsInTextLine.forEach(printWriter::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
