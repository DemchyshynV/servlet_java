package bookСlub;

import lombok.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static java.util.stream.Collectors.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BookClub {

    List<Person> bookClub = new ArrayList<>();

    {
        Book becoming = new Book("Becoming", 200, 2007);
        Book aTimeForMercy = new Book("A time for mercy", 120, 2000);
        Book theReturn = new Book("The return", 510, 1990);
        Book daylight = new Book("Daylight", 50, 2010);
        Book greenlights = new Book("Greenlights", 600, 1999);
        Book untamed = new Book("Untamed", 170, 2003);
        Book deadlyCross = new Book("Deadly cross", 70, 2011);

        List<Book> library1 = Arrays.asList(becoming, theReturn);
        List<Book> library2 = Arrays.asList(aTimeForMercy, deadlyCross, theReturn);
        List<Book> library3 = Arrays.asList(becoming, daylight);
        List<Book> library4 = Arrays.asList(untamed, theReturn, greenlights);
        List<Book> library5 = Arrays.asList(greenlights, theReturn);

        bookClub.add(new Person("roksi", LocalDate.of(2000, Month.APRIL, 5), "woman", library1));
        bookClub.add(new Person("lili", LocalDate.of(1999, Month.JULY, 20), "woman", library2));
        bookClub.add(new Person("max", LocalDate.of(2003, Month.FEBRUARY, 1), "man", library3));
        bookClub.add(new Person("anton", LocalDate.of(1990, Month.AUGUST, 7), "man", library4));
        bookClub.add(new Person("ann", LocalDate.of(1992, Month.DECEMBER, 11), "woman", library5));
    }


//    1. згенерувати мапу <Person, Integer>, де Integer - кількість сторінок усіх книжок, які має людина
    public void peopleWithTheirBookPagesToMap() {
        Map<Person, Integer> peopleBookPages = this.bookClub.stream()
                .collect(toMap(person -> person,
                               person ->  person.getBooks().stream()
                                            .mapToInt(Book::getPages)
                                            .reduce(0, Integer::sum),
                                          // or
                                          // .sum(),

                                          // to TreeMap
                                          (oldValue, newValue) -> oldValue,
                                          TreeMap::new
                ));

        peopleBookPages.forEach((k, v) -> System.out.println("name: " + k.getName() + ", amount of book pages: " + v));
    }


//    2. згенерувати мапу <String, Book>, де String - ім'я людини, Book - книжка з найбільшою кількістю сторінок
    public void peopleWithTheirBiggestBookToMap() {
        Map<String, Book> peopleBiggestBook = this.bookClub.stream()
                .collect(toMap(Person::getName,
                               person -> person.getBooks().stream()
//                                            .max((b1, b2) -> b1.getPages() - b2.getPages())
                                            // or
//                                            .max(Comparator.comparingInt(Book::getPages))
                                            // or
                                            .reduce((b1, b2) -> b1.getPages() > b2.getPages() ? b1 : b2)
                                            .get(),

                                              // or
//                                            person -> person.getBooks().stream()
//                                                        .sorted((b1, b2) -> b2.getPages() - b1.getPages())
//                                                        .findFirst().get(),
                                          (oldValue, newValue) -> oldValue,
                                          TreeMap::new
                ));

        peopleBiggestBook.forEach((k, v) -> System.out.println("name: " + k + ", the biggest book: " + v));
    }


//    3. згенерувати List<Book> відфільтрувавши тільких тих людей, хто старше 25 років і книжки які мають більше 500 сторінок
    public void booksFilteredByPeopleAgeAndBookPages() {
        LocalDate now = LocalDate.now();

        List<Book> filteredBooks = bookClub.stream()
                .filter(person ->  now.getYear() - person.getBirthday().getYear() > 25)
                .map(Person::getBooks)
                .flatMap(List::stream)
                .filter(book -> book.getPages() > 500)
                .distinct()
                .collect(toList());

        filteredBooks.forEach(System.out::println);
    }


    // ДОДАТКОВІ:

    // сформувати два Map<String, List<Book>>,
    // 1 - жінки, які молодші середнього віку учасників клубу, та омолодити їх на 5 років
    // 2 - чоловіки, які старші середнього віку та зробити їх старшими на 10 років
    public void peopleFilteredByMiddleAge() {
        LocalDate now = LocalDate.now();
        double middleAge = this.bookClub.stream()
                .mapToInt(p -> now.getYear() - p.getBirthday().getYear())
                .average()
                .getAsDouble();

        Map<String, List<Book>> youngerMiddleAgedWoman = this.bookClub.stream()
                .filter(person -> now.getYear() - person.getBirthday().getYear() < middleAge && person.getSex().equals("woman"))
                .peek(person -> person.setBirthday(LocalDate.of(person.getBirthday().getYear() + 5,
                                                                  person.getBirthday().getMonth(),
                                                                  person.getBirthday().getDayOfMonth())))
                .collect(toMap(person -> "Person (name: " + person.getName() + ", age: "
                                         + (now.getYear() - person.getBirthday().getYear()) + ")",
                               Person::getBooks));

        System.out.println("younger middle-aged: ");
        youngerMiddleAgedWoman.forEach((k, v) -> System.out.println(k + "\n books: " + v));


        Map<String, List<Book>> olderMiddleAgedMan = this.bookClub.stream()
                .filter(person -> now.getYear() - person.getBirthday().getYear() > middleAge && person.getSex().equals("man"))
                .peek(person -> person.setBirthday(LocalDate.of(person.getBirthday().getYear() - 10,
                                                                  person.getBirthday().getMonth(),
                                                                  person.getBirthday().getDayOfMonth())))
                .collect(toMap(person -> "Person (name: " + person.getName() + ", age: "
                                         + (now.getYear() - person.getBirthday().getYear()) + ")",
                               Person::getBooks));

        System.out.println("\nolder middle-aged: ");
        olderMiddleAgedMan.forEach((k, v) -> System.out.println(k + "\n books: " + v));
    }


    // сформувати Map<String, Book>, де String -  імя та вік двох наймолодших учасників клубу,
    // Book - книга кожного учасника із його List<Book>, яка була найшвидше опублікована
    public void peopleAgeBookYearOfPublishingToMap() {
        LocalDate now = LocalDate.now();

        Map<String, Book> peopleEarlierBook = this.bookClub.stream()
                .sorted((p1, p2) -> {
                    int p1Age = now.getYear() - p1.getBirthday().getYear();
                    int p2Age = now.getYear() - p2.getBirthday().getYear();

                    return p1Age - p2Age;
                })
                .limit(2)
                .collect(toMap(person -> "Person (name: " + person.getName() + ", age: "
                                                    + (now.getYear() - person.getBirthday().getYear()) + ")",
                               person -> person.getBooks().stream()
                                            .min(Comparator.comparingInt(Book::getYearOfPublishing))
                                            .get(),
                               (oldValue, newValue) -> oldValue,
                               TreeMap::new));

        peopleEarlierBook.forEach((k, v) -> System.out.println(k + ", the fastest published book: " + v));
    }


    // створити Map<String, Integer>, де String - ім'я учасника, Integer - його вік,
    // відфільтрувати та залишити тих учасників у кого вік >= 20 та тих в кого ім'я містить літеру - "n",
    // відфільтрованим учасникам - встановити новий вік - 18, та додати псевдонім до імені,
    // name = "поточне ім'я - назва книги із його списку, яка найпізніше опублікована"
    public void peopleNameAgeToMap() {
        LocalDate now = LocalDate.now();

        Map<String, Integer> nameAgeToMap = this.bookClub.stream()
                .filter(person -> now.getYear() - person.getBirthday().getYear() >= 20 && person.getName().toLowerCase().contains("n"))
                .map(person -> {
                    Book book = person.getBooks().stream()
                                    .max(Comparator.comparingInt(Book::getYearOfPublishing))
//                                    .orElseThrow(NoSuchElementException::new);
                                    .get();
                    person.setName(person.getName() + "-" + book.getTitle());

                    person.setBirthday(LocalDate.of(now.getYear() - 18,
                                       person.getBirthday().getMonth(),
                                       person.getBirthday().getDayOfMonth()));
                    return person;
                })
                .collect(toMap(Person::getName,
                               person -> now.getYear() - person.getBirthday().getYear(),
                               (oldValue, newValue) -> oldValue,
                               TreeMap::new));

        nameAgeToMap.forEach((k, v) -> System.out.println("name: " + k + ", new age: " + v));
    }


    // сформувати Map<String, List<Book>>, де String - ім'я учасника, у якого List<Book> > 2
    // залишивши у List<Book> лише ті книги, назва яких має більше 10 літер
    // та зменшити цим книгам кількість сторінок удвічі
    public void peopleNameListOfBooksToMap() {
        Map<String, List<Book>> nameListOfBooksToMap = this.bookClub.stream()
                .filter(person -> person.getBooks().stream().count() > 2)
                .collect(toMap(Person::getName,
                               person -> person.getBooks().stream()
                                            .filter(book -> book.getTitle().trim().length() > 10)
                                            .map(book -> {
                                                book.setPages(book.getPages() / 2);
                                                return book;
                                            })
                                            .collect(toList()),
                               (oldValue, newValue) -> oldValue,
                               TreeMap::new
                               ));

        nameListOfBooksToMap.forEach((k, v) -> System.out.println("name: " + k + "\n books: " + v));
    }
}
