package atelier;

import atelier.enums.SizeOfClothing;
import atelier.interfaces.MensClothes;
import lombok.*;

@NoArgsConstructor

public class Tie extends Clothing implements MensClothes {

    public Tie(SizeOfClothing size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("dress man in a " + this.getClass().getSimpleName());
    }
}
