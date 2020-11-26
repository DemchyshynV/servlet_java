package animalsAtTheVet;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Cat extends Animal {

    private final String description = "The cat is a domestic species of small carnivorous mammal.";
    private String color;

    public Cat(String food, String location) {
        super(food, location);
    }

    public Cat(String food, String location, String color) {
        super(food, location);
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
