package animalsAtTheVet;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Dog("meat", "Lviv", 5, 20.4));
        animals.add(new Cat("fish", "Kyiv", "brown", "Tom"));
        animals.add(new Horse("grass", "Solonka", 155.5, true));

        for (Animal animal : animals) {
            Vet.treatAnimal(animal);
        }

    }
}
