package atelier;

import atelier.enums.SizeOfClothing;
import atelier.interfaces.WomensClothes;
import lombok.*;

@NoArgsConstructor

public class Dress extends Clothing implements WomensClothes {

    public Dress(SizeOfClothing size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("dress woman in a " + this.getClass().getSimpleName());
    }
}
