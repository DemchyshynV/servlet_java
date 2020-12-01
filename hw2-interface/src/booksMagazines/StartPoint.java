package booksMagazines;

import java.util.ArrayList;
import java.util.List;

public class StartPoint {

    public static void main(String[] args) {

        List<Printable> booksAndMagazines = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            booksAndMagazines.add(new Book("bookName" + (i + 1), 2000 + i));
            booksAndMagazines.add(new Magazine("magazineName" + (i + 1), 2010 + i));
        }

        for (Printable bookAndMagazine : booksAndMagazines) bookAndMagazine.print();

        Magazine.printMagazines(booksAndMagazines);
        Book.printBooks(booksAndMagazines);

    }
}
