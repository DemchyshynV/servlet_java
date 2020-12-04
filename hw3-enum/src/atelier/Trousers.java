package atelier;

import atelier.enums.SizeOfClothing;
import atelier.interfaces.MensClothes;
import atelier.interfaces.WomensClothes;
import lombok.*;

@NoArgsConstructor

public class Trousers extends Clothing implements MensClothes, WomensClothes {

    public Trousers(SizeOfClothing size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("dress man in a " + this.getClass().getSimpleName());
    }

    @Override
    public void dressWoman() {
        System.out.println("dress woman in a " + this.getClass().getSimpleName());
    }
}
