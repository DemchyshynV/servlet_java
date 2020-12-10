package zooClub;

import zooClub.enums.ActionTypes;

import java.util.Scanner;

public class StartPoint {

    public static void main(String[] args) {

        menuOptions();
        menu();
    }

    public static void menu() {
        System.out.print("\n Make your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                ZooClub.addPerson();
                menu();
                break;

            case 2:
                ZooClub.getPersonIfExists(ActionTypes.ADD_PET);
                menu();
                break;

            case 3:
                ZooClub.getPersonIfExists(ActionTypes.REMOVE_PET);
                menu();
                break;

            case 4:
                ZooClub.removePerson();
                menu();
                break;

            case 5:
                ZooClub.removePetFromAllParticipants();
                menu();
                break;

            case 6:
                ZooClub.showClubParticipants();
                menu();
                break;

            case 7:
                System.out.println("you have left the menu");
                break;

            default:
                System.out.println("incorrect number, try again");
                menu();
        }
    }

    public static void menuOptions() {
        // всі дії виконую за іменем
        System.out.println("1) додати учасника в клуб");
        System.out.println("2) додати тваринку до учасника клубу");
        System.out.println("3) видалити тваринку з власника");
        System.out.println("4) видалити учасника клубу");
        System.out.println("5) видалити конкретну тваринку з усіх власників");
        System.out.println("6) вивести на екран зооклуб");
        System.out.println("7) вихід з меню");
    }
}
