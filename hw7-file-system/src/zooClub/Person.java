package zooClub;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person implements Comparable<Person>, Serializable {

    private int id;
    private String nickname;
    private int age;
    private List<Pet> pets;

    public Person(int id, String nickname, int age) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.getId() - person.getId();
    }
}
