package zooClub;

import org.json.JSONArray;

public class StartPoint {

    public static void main(String[] args) {

        FolderWithDataCreator.jsonDataCreator();

        ZooClub zooClub = new ZooClub();

        zooClub.addParticipantsFromJsonFile();
        zooClub.addParticipant(new Person(10, "olya", 40));
        zooClub.addPetToParticipant("olya", new Pet("jecki", "cat"));
        zooClub.removePetFromParticipant("roksi", "koko");
        zooClub.removeParticipant("lili");
        zooClub.removePetFromAllParticipants("richi");
        zooClub.showClubParticipants();



//        zooClub.addParticipantToJsonFile(FolderWithDataCreator.jsonPersonCreator(6, "tom", 30, new JSONArray()));
//        zooClub.addPetToParticipantToJsonFile("roksi", FolderWithDataCreator.jsonPetCreator("jiji", "fish"));
//        zooClub.addPetToParticipantToJsonFile("ann", FolderWithDataCreator.jsonPetCreator("pomidor", "dog"));
//        zooClub.removeParticipantFromJsonFile("max");
//        zooClub.showClubParticipants();
    }
}
