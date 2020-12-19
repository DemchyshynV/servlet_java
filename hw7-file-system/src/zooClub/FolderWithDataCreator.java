package zooClub;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FolderWithDataCreator {

    private final static File folder = new File("data");
    private final static File file = new File(folder + "/zoo-club-participants.json");


    public static void folderFileCreator(JSONArray zooClub) {
        if (!folder.exists()) {
            folder.mkdir();
            fileWithDataCreator(zooClub);
            return;
        }

        fileWithDataCreator(zooClub);
    }


    public static void fileWithDataCreator(JSONArray zooClub) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            printWriter.println(zooClub);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void jsonDataCreator() {
        JSONArray jsonData = new JSONArray();

        JSONArray roksiPets = new JSONArray();
        JSONArray liliPets = new JSONArray();
        JSONArray harryPets = new JSONArray();

        roksiPets.put(jsonPetCreator("koko", "chicken"));
        roksiPets.put(jsonPetCreator("richi", "dog"));
        liliPets.put(jsonPetCreator("murzik", "cat"));
        harryPets.put(jsonPetCreator("pockemon", "hamster"));
        harryPets.put(jsonPetCreator("rocki", "parrot"));
        harryPets.put(jsonPetCreator("jeck", "dog"));

        jsonData.put(jsonPersonCreator(1, "roksi", 20, roksiPets));
        jsonData.put(jsonPersonCreator(2, "lili", 25, liliPets));
        jsonData.put(jsonPersonCreator(3, "max", 19, new JSONArray()));
        jsonData.put(jsonPersonCreator(4, "harry", 26, harryPets));
        jsonData.put(jsonPersonCreator(5, "ann", 28, new JSONArray()));

        folderFileCreator(jsonData);
    }


    public static JSONObject jsonPersonCreator(int id, String nickname, int age, JSONArray pets) {
        JSONObject person = new JSONObject();
        person.put ("id", id);
        person.put ("nickname", nickname);
        person.put("age", age);

        person.put("pets", pets);

        return person;
    }


    public static JSONObject jsonPetCreator(String name, String specie) {
        JSONObject pet = new JSONObject();
        pet.put ("name", name);
        pet.put ("specie", specie);

        return pet;
    }


    public static File getFile() {
        return file;
    }
}
