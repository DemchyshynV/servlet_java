package products.helper;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static List<String> stringNumbersCreator() {
        List<String> stringNumbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringNumbers.add(Integer.toString(i));
        }

        return stringNumbers;
    }
}
