package storage;

import lombok.*;

@Data

public class LineStorage {

    private String textOfLine;
    private boolean available;

    public LineStorage() {
        this.available = false;
    }

    public String get() {
        while (!this.available) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.available = false;
        notifyAll();

        return this.textOfLine;
    }

    public void put(String value) {
        while (this.available) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.available = true;
        this.textOfLine = value;
        notifyAll();
    }
}
