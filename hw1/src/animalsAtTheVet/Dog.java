package animalsAtTheVet;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor // don't include super
@Data
@ToString(callSuper = true)

public class Dog extends Animal {

    private final String description = "The dog is a domesticated carnivore of the family Canidae.";
    private int age;

    public Dog(String food, String location) {
        super(food, location);
    }

    public Dog(String food, String location, int age) {
        super(food, location);
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
