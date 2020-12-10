package zooClub.helper;

import zooClub.Creature;
import zooClub.Person;
import zooClub.Pet;
import zooClub.enums.CreatureTypes;
import zooClub.enums.FieldTypes;

import java.util.Scanner;

public class Helper {

    public static Object fieldCreator(CreatureTypes creature, FieldTypes fieldType) {
        System.out.println("enter " + creature + " " + fieldType + ":");
        Scanner scanner = new Scanner(System.in);

        if (fieldType.equals(FieldTypes.AGE)) {
            return scanner.nextInt();
        }

        return scanner.nextLine().toLowerCase();
    }

    public static Creature creatureCreator(CreatureTypes creature) {
        if (creature.equals(CreatureTypes.PERSON)) {
            return new Person(
                    (String) Helper.fieldCreator(CreatureTypes.PERSON, FieldTypes.NAME),
                    (int) Helper.fieldCreator(CreatureTypes.PERSON, FieldTypes.AGE),
                    (String) Helper.fieldCreator(CreatureTypes.PERSON, FieldTypes.HOMETOWN)
            );
        }
        
        return new Pet(
                (String) Helper.fieldCreator(CreatureTypes.PET, FieldTypes.NAME),
                (int) Helper.fieldCreator(CreatureTypes.PET, FieldTypes.AGE),
                (String) Helper.fieldCreator(CreatureTypes.PET, FieldTypes.COLOR)
        );
    }
}
