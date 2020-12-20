package zooClub;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FolderWithDataCreator {

    private final static File FOLDER = new File("data");
    private final static File JSON_FILE = new File(FOLDER  + "/zoo-club-participants.json");
    private final static File TXT_FILE = new File(FOLDER + "/zoo-club-participants.txt");


    // for txt file
    public static void folderTxtFileCreator(List<Person> zooClub) {
        if (!FOLDER.exists()) {
            FOLDER.mkdir();
            txtFileWithDataCreator(zooClub);
            return;
        }

        txtFileWithDataCreator(zooClub);
    }


    public static void txtFileWithDataCreator(List<Person> zooClub) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(TXT_FILE))) {
            for (Person person : zooClub) {
                objectOutputStream.writeObject(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void txtDataCreator() {
        List<Person> zooClub = new ArrayList<>();

        List<Pet> roksiPets = Arrays.asList(new Pet("koko", "chicken"), new Pet("richi", "dog"));
        List<Pet> liliPets = Arrays.asList(new Pet("murzik", "cat"));
        List<Pet> harryPets = Arrays.asList(new Pet("pockemon", "hamster"), new Pet("rocki", "parrot"), new Pet("richi", "dog"));

        zooClub.add(new Person(1, "roksi", 20, roksiPets));
        zooClub.add(new Person(2, "lili", 25, liliPets));
        zooClub.add(new Person(3, "max", 19, new ArrayList<>()));
        zooClub.add(new Person(4, "harry", 26, harryPets));
        zooClub.add(new Person(5, "ann", 28, new ArrayList<>()));

        folderTxtFileCreator(zooClub);
    }




    // for json file
    public static void folderJsonFileCreator(JSONArray jsonZooClub) {
        if (!FOLDER.exists()) {
            FOLDER.mkdir();
            jsonFileWithDataCreator(jsonZooClub);
            return;
        }

        jsonFileWithDataCreator(jsonZooClub);
    }


    public static void jsonFileWithDataCreator(JSONArray zooClub) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(JSON_FILE))) {
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
        harryPets.put(jsonPetCreator("richi", "dog"));

        jsonData.put(jsonPersonCreator(1, "roksi", 20, roksiPets));
        jsonData.put(jsonPersonCreator(2, "lili", 25, liliPets));
        jsonData.put(jsonPersonCreator(3, "max", 19, new JSONArray()));
        jsonData.put(jsonPersonCreator(4, "harry", 26, harryPets));
        jsonData.put(jsonPersonCreator(5, "ann", 28, new JSONArray()));

        folderJsonFileCreator(jsonData);
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


    public static File getJsonFile() {
        return JSON_FILE;
    }

    public static File getTxtFile() {
        return TXT_FILE;
    }
}
