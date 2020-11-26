package animalsAtTheVet;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor // don't include super
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Horse extends Animal {

    private final String description = "Horses are adapted to run, allowing them to quickly escape predators.";
    private double height;

    public Horse(String food, String location) {
        super(food, location);
    }

    public Horse(String food, String location, double height) {
        super(food, location);
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
