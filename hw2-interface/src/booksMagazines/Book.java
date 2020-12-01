package booksMagazines;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Book extends BookMagazineTemplate implements Printable {

    public Book(String name, int year) {
        super(name, year);
    }

    public static void printBooks(List<Printable> printable) {
        for (Printable printBookMagazine : printable) {
            if (printBookMagazine instanceof Book) {
                System.out.println(((Book) printBookMagazine).getName());
            }
        }
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
