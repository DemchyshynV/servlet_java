package zooClub;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Person extends Creature {

    private String hometown;

    public Person(String name, int age, String hometown) {
        super(name, age);
        this.hometown = hometown;
    }
}
