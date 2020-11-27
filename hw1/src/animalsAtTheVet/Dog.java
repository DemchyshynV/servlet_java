package animalsAtTheVet;

import lombok.*;

@AllArgsConstructor // don't include super
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Dog extends Animal {

    private final String description = "The dog is a domesticated carnivore of the family Canidae.";
    private final double weight;
    private int age;

    public Dog(double weight) {
        this.weight = weight;
    }

    public Dog(String food, String location, double weight) {
        super(food, location);
        this.weight = weight;
    }

    public Dog(String food, String location, int age, double weight) {
        super(food, location);
        this.weight = weight;
        this.age = age;
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
