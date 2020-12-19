package zooClub;

import org.json.JSONArray;

public class StartPoint {

    public static void main(String[] args) {

        FolderWithDataCreator.jsonDataCreator();

        ZooClub zooClub = new ZooClub();
//
//        zooClub.addParticipantsFromJsonFile();
//        zooClub.addParticipantToJsonFile(FolderWithDataCreator.jsonPersonCreator(6, "tom", 30, new JSONArray()));
//        zooClub.addPetToParticipantToJsonFile("roksi", FolderWithDataCreator.jsonPetCreator("jiji", "fish"));
//        zooClub.addPetToParticipantToJsonFile("ann", FolderWithDataCreator.jsonPetCreator("pomidor", "dog"));
        zooClub.removeParticipantFromJsonFile("max");
        zooClub.showClubParticipants();
    }
}
