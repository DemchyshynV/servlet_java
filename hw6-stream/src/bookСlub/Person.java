package bookСlub;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person implements Comparable<Person> {

    private String name;
    private LocalDate birthday;
    private String sex;
    private List<Book> books = new ArrayList<>();

    @Override
    public int compareTo(Person person) {
        return this.getName().compareToIgnoreCase(person.getName());
    }
}
