package storage;

import lombok.*;

@Data

public class LineStorage {

    private String textOfLine;
    private boolean printed;

    public LineStorage() {
        this.printed = true;
    }
}
