package zooClub;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person implements Comparable<Person> {

    private int id;
    private String nickname;
    private int age;

    @Override
    public int compareTo(Person person) {
        return this.getId() - person.getId();
    }
}
