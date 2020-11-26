package animalsAtTheVet;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data // Getter + Setter + ToString + EqualsAndHashCode + RequiredArgsConstructor

public class Animal {

    private String food;
    private String location;

    public void makeNoise() {
        System.out.println(this + " is making noise.");
    }

    public void eat() {
        System.out.println("Favorite animal food is " + getFood());
    }

    public void sleep(boolean isSleepWell) {
        if (isSleepWell) System.out.println(this + " sleeps well.");

        System.out.println(this + " sleeps bad.");
    }
}
