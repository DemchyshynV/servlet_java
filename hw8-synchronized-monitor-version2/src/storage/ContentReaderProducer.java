package storage;

import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ContentReaderProducer implements Runnable {

    private LineStorage lineStorage;

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/aboutMonitor.txt"))){

            synchronized (this.lineStorage) {
                String textLine = "";

                while ((textLine = bufferedReader.readLine()) != null) {
                    this.lineStorage.put(textLine);
//                    System.out.println(Thread.currentThread().getName() + " put: " + textLine);

                    try {
                        Thread.sleep((long) (Math.random() * 100));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
