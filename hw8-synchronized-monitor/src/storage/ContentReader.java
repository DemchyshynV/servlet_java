package storage;

import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ContentReader implements Runnable {

   private LineStorage lineStorage;

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/aboutMonitor.txt"))){

            synchronized (this.lineStorage) {
                String textLine = "";

                while ((textLine = bufferedReader.readLine()) != null) {
                    if (!this.lineStorage.isPrinted()) {
                        try {
                            this.lineStorage.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    this.lineStorage.setTextOfLine(textLine);
                    this.lineStorage.setPrinted(false);
                    this.lineStorage.notify();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
