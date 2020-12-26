package zooClub;

import zooClub.enums.ActionTypes;

import java.util.Scanner;

public class StartPoint {

    public static void main(String[] args) {

        menuOptions();
        menu();
        System.out.println(111);
    }

    // 1
//    public static void menu() {
//        System.out.print("\n Make your choice: ");
//        Scanner scanner = new Scanner(System.in);
//        int choice = scanner.nextInt();
//
//        switch (choice) {
//
//            case 1:
//                ZooClub.addPerson();
//                menu();
//                break;
//
//            case 2:
//                ZooClub.getPersonIfExists(ActionTypes.ADD_PET);
//                menu();
//                break;
//
//            case 3:
//                ZooClub.getPersonIfExists(ActionTypes.REMOVE_PET);
//                menu();
//                break;
//
//            case 4:
//                ZooClub.removePerson();
//                menu();
//                break;
//
//            case 5:
//                ZooClub.removePetByNameFromAllParticipants();
//                menu();
//                break;
//
//            case 6:
//                ZooClub.showClubParticipants();
//                menu();
//                break;
//
//            case 7:
//                System.out.println("you have left the menu");
//                break;
//
//            default:
//                System.out.println("incorrect number, try again");
//                menu();
//        }
//    }

    // 2
    public static void menu() {
        System.out.print("\n Make your choice: ");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int choice = scanner.nextInt();

            if (choice == 1) {
                ZooClub.addPerson();

            } else if (choice == 2) {
                ZooClub.getPersonIfExists(ActionTypes.ADD_PET);

            } else if (choice == 3) {
                ZooClub.getPersonIfExists(ActionTypes.REMOVE_PET);

            } else if (choice == 4) {
                ZooClub.removePerson();

            } else if (choice == 5) {
                ZooClub.removePetByNameFromAllParticipants();

            } else if (choice == 6) {
                ZooClub.showClubParticipants();

            } else if (choice == 7) {
                System.out.println("you have left the menu");
                scanner.close();
                return;

            } else {
                System.out.println("incorrect number, try again");
            }

            menu();
        }
    }

    public static void menuOptions() {
        // всі дії виконую за іменем
        System.out.println("1) додати учасника в клуб");
        System.out.println("2) додати тваринку до учасника клубу");
        System.out.println("3) видалити тваринку з власника");
        System.out.println("4) видалити учасника клубу");

        // видаляю усіх тваринок, у яких ім'я = введеному імені, із усіх учасників клубу
        System.out.println("5) видалити конкретну тваринку з усіх власників");

        System.out.println("6) вивести на екран зооклуб");
        System.out.println("7) вихід з меню");
    }
}
