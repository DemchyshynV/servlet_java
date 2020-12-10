package zooClub;

import zooClub.enums.ActionTypes;
import zooClub.enums.CreatureTypes;
import zooClub.enums.FieldTypes;
import zooClub.helper.Helper;
import lombok.Data;

import java.util.*;

@Data

public class ZooClub {

    private static Map<Person, List<Pet>> club = new HashMap<>();


    public static void addPerson() {
        Person person = (Person) Helper.creatureCreator(CreatureTypes.PERSON);

//        int clubParticipants = zooClub.size();
//        zooClub.putIfAbsent(person, new ArrayList<>());
//
//        if (clubParticipants == zooClub.size()) {
//            System.out.println("the same person already exists");
//            return;
//        }


        // or
        if (club.containsKey(person)) {
            System.out.println("the same person already exists.");
            return;
        }

        club.put(person, new ArrayList<>());

        System.out.println("person has been added");
    }


    public static void getPersonIfExists(ActionTypes action) {
        String name = (String) Helper.fieldCreator(CreatureTypes.PERSON, FieldTypes.NAME);

        for (Person person : club.keySet()) {
            if (person.getName().equals(name)) {
                if (action.equals(ActionTypes.ADD_PET)) {
                    addPetToPerson(person);
                    return;
                }

                removePetFromPerson(person);
                return;
            }
        }

        System.out.println("there is no person with that name in the zooClub");
    }


    public static void addPetToPerson(Person person) {
        Pet pet = (Pet) Helper.creatureCreator(CreatureTypes.PET);
        List<Pet> pets = club.get(person);
        pets.add(pet);

        club.replace(person, pets);         // result is the same - zooClub.put(person, pets);
        System.out.println("pet has been added");
    }


    public static void removePetFromPerson(Person person) {
        String name = (String) Helper.fieldCreator(CreatureTypes.PET, FieldTypes.NAME);

        Iterator<Pet> petIterator = club.get(person).iterator();
        while (petIterator.hasNext()) {
            Pet product = petIterator.next();
            if (product.getName().equals(name)) {
                petIterator.remove();
                System.out.println("pet has been removed");
                return;
            }
        }


        //or
//        for (Pet pet : zooClub.get(person)) {
//            if (pet.getName().equals(name)) {
//                zooClub.get(person).remove(pet);
//                System.out.println("pet has been removed");
//                return;
//            }
//        }


        // or
//        int petsQuantity = zooClub.get(person).size();
//
//        zooClub.get(person).removeIf(pet -> pet.getName().equals(name));
//
//        if(petsQuantity != zooClub.get(person).size()) {
//            System.out.println("pet has been removed");
//            return;
//        }

        System.out.println(person.getName() + " doesn't have pet - " + name);
    }


    public static void removePerson() {
        String name = (String) Helper.fieldCreator(CreatureTypes.PERSON, FieldTypes.NAME);

        Iterator<Person> personIterator = club.keySet().iterator();
        while (personIterator.hasNext()) {
            Person person = personIterator.next();
            if (person.getName().equals(name)) {
                personIterator.remove();
                System.out.println("person has been removed");
                return;
            }
        }


        // or
//        for (Person person : zooClub.keySet()) {
//            if (person.getName().equals(name)) {
//                zooClub.remove(person);
//                System.out.println("person has been removed");
//                return;
//            }
//        }

        System.out.println("there is no person with that name in the zooClub");
    }


    public static void removePetFromAllParticipants() {
        String name = (String) Helper.fieldCreator(CreatureTypes.PET, FieldTypes.NAME);
        int petsQuantityBeforeRemoval = 0;      // for message - is pet removed or no
        int petsQuantityAfterRemoval = 0;

        Iterator<List<Pet>> petListOfListIterator = club.values().iterator();
        while (petListOfListIterator.hasNext()) {
            List<Pet> pets = petListOfListIterator.next();
            petsQuantityBeforeRemoval += pets.size();                   // for message - is pet removed or no
            Iterator<Pet> petsIterator = pets.iterator();

            while (petsIterator.hasNext()) {
                Pet pet = petsIterator.next();
                if (pet.getName().equals(name)) {
                    petsIterator.remove();
                }
            }
        }


        // or
//        for (List<Pet> pets : zooClub.values()) {
//            petsQuantityBeforeRemoval += pets.size();                 // for message - is pet removed or no
//            pets.removeIf(pet -> pet.getName().equals(name));
//        }

        for (List<Pet> pets : club.values()) {                          // for message - is pet removed or no
            petsQuantityAfterRemoval += pets.size();
        }

        if (petsQuantityBeforeRemoval == petsQuantityAfterRemoval) {     // for message - is pet removed or no
            System.out.println("no pet with this name");
            return;
        }

        System.out.println("all pets with entered name have been removed");
    }


    public static void showClubParticipants() {
        if (club.isEmpty()) {
            System.out.println("there are no people in the zooClub");
            return;
        }

        System.out.println("all zooClub participants:");
        for (Map.Entry<Person, List<Pet>> personWithPets : club.entrySet()) {
            System.out.println(personWithPets);
        }
    }

    public static Map<Person, List<Pet>> getClub() {
        return club;
    }

    public static void setClub(Map<Person, List<Pet>> club) {
        ZooClub.club = club;
    }
}
