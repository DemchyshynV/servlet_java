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
                    (String) Helper.fieldCreator(creature, FieldTypes.NAME),
                    (int) Helper.fieldCreator(creature, FieldTypes.AGE),
                    (String) Helper.fieldCreator(creature, FieldTypes.HOMETOWN)
            );
        }
        
        return new Pet(
                (String) Helper.fieldCreator(creature, FieldTypes.NAME),
                (int) Helper.fieldCreator(creature, FieldTypes.AGE),
                (String) Helper.fieldCreator(creature, FieldTypes.COLOR)
        );
    }
}
