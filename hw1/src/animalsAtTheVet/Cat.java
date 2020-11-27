package animalsAtTheVet;

import lombok.*;

@AllArgsConstructor // don't include super
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Cat extends Animal {

    private final String description = "The cat is a domestic species of small carnivorous mammal.";
    private final String owner;
    private String color;

    public Cat(String owner) {
        this.owner = owner;
    }

    public Cat(String food, String location, String owner) {
        super(food, location);
        this.owner = owner;
    }

    public Cat(String food, String location, String color, String owner) {
        super(food, location);
        this.owner = owner;
        this.color = color;
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
