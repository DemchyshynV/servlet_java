package storage;

import lombok.*;

import java.io.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ContentPrinterFirstConsumer implements Runnable {

    private LineStorage lineStorage;

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/aboutMonitor.txt"))) {

            synchronized (this.lineStorage) {
                while ((bufferedReader.readLine()) != null) {

                    try {
                        Thread.sleep((long) (Math.random() * 300));
                        String textLine = this.lineStorage.get();
                        System.out.println(Thread.currentThread().getName() + " get: " + textLine);

                        rewriteFile(textLine);

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
}
