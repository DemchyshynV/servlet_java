package storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class WordPrinterSecondConsumer implements Runnable {

    private LineStorage lineStorage;

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/aboutMonitor.txt"))) {

            synchronized (this.lineStorage) {
                while ((bufferedReader.readLine()) != null) {

                    try {
                        Thread.sleep((long) (Math.random() * 400));
                        String textLine = this.lineStorage.get();
                        System.out.println(Thread.currentThread().getName() + " get: " + textLine);

                        wordWriter(textLine);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

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
