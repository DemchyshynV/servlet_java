package booksMagazines;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class Magazine extends BookMagazineTemplate implements Printable {

    public Magazine(String name, int year) {
        super(name, year);
    }

    public static void printMagazines(List<Printable> printable){
        for (Printable printBookMagazine : printable) {
            if (printBookMagazine instanceof Magazine) {
                System.out.println(((Magazine) printBookMagazine).getName());
            }
        }
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
