package zooClub;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Pet extends Creature {

    private String color;

    public Pet(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }
}
