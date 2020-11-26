package animalsAtTheVet;

public class Vet {

    public static void treatAnimal(Animal animal) {
        System.out.println("The animal lives in " + animal.getLocation() + " and eats " + animal.getFood());
    }
}
