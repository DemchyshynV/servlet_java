package atelier;

import atelier.enums.SizeOfClothing;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public abstract class Clothing {

    private SizeOfClothing size;
    private double price;
    private String color;
}
