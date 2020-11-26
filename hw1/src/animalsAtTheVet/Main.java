package animalsAtTheVet;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Dog("meat", "Lviv", 5));
        animals.add(new Cat("fish", "Kyiv", "brown"));
        animals.add(new Horse("grass", "Solonka", 155.5));

        for (Animal animal : animals) {
            Vet.treatAnimal(animal);
        }

    }
}
