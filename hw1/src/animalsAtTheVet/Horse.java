package animalsAtTheVet;

import lombok.*;

@AllArgsConstructor // don't include super
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Horse extends Animal {

    private final String description = "Horses are adapted to run, allowing them to quickly escape predators.";
    private final boolean isThoroughbred;
    private double height;

    public Horse(boolean isThoroughbred) {
        this.isThoroughbred = isThoroughbred;
    }

    public Horse(String food, String location, boolean isThoroughbred) {
        super(food, location);
        this.isThoroughbred = isThoroughbred;
    }

    public Horse(String food, String location, double height, boolean isThoroughbred) {
        super(food, location);
        this.isThoroughbred = isThoroughbred;
        this.height = height;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
    }

    @Override
    public void eat() {
        super.eat();
    }
}
