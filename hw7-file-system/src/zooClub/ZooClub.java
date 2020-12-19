package zooClub;

import org.json.JSONArray;
import org.json.JSONObject;
import zooClub.myExceptions.MyJSONException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ZooClub {

    private final Map<Person, List<Pet>> zooClub = new TreeMap<>();


    public void addParticipantsFromJsonFile() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getFile()))) {

            JSONArray data = new JSONArray(bufferedReader.readLine());

            data.forEach(o -> {
                JSONObject person = (JSONObject) o;

                try {
                    addPetFromJsonFile(person);
                } catch (MyJSONException e) {
                    e.printStackTrace();
                    this.zooClub.put(new Person((int) person.get("id"),
                                                (String) person.get("nickname"),
                                                (int) person.get("age")),
                                     new ArrayList<>());
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addPetFromJsonFile(JSONObject person) throws MyJSONException {

        if (person.getJSONArray("pets").isEmpty()) {
            throw new MyJSONException(person.get("nickname") + " doesn't have pets", ", add somebody");
        }

        List<Pet> petList = new ArrayList<>();

        person.getJSONArray("pets").forEach(o -> {
            JSONObject pet = (JSONObject) o;

            petList.add(new Pet((String) pet.get("name"), (String) pet.get("specie")));

            this.zooClub.put(new Person((int) person.get("id"),
                                        (String) person.get("nickname"),
                                        (int) person.get("age")),
                             petList);
        });
    }


    public void addParticipantToJsonFile(JSONObject person) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getFile()))) {

            JSONArray data = new JSONArray(bufferedReader.readLine());
            data.put(person);

            FolderWithDataCreator.fileWithDataCreator(data);
            addParticipantsFromJsonFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addPetToParticipantToJsonFile(String nickname, JSONObject pet) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getFile()))) {

            JSONArray data = new JSONArray(bufferedReader.readLine());

            data.forEach(o -> {
                JSONObject person = (JSONObject) o;

                if (person.get("nickname").equals(nickname)) {
                   person.getJSONArray("pets").put(pet);
                }
            });

            FolderWithDataCreator.fileWithDataCreator(data);
            addParticipantsFromJsonFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeParticipantFromJsonFile(String nickname) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getFile()))) {

            JSONArray data = new JSONArray(bufferedReader.readLine());
            JSONArray newData = new JSONArray();

            data.forEach(o -> {
                JSONObject person = (JSONObject) o;

                if (!person.get("nickname").equals(nickname)) {
                    newData.put(person);
                }
            });

            FolderWithDataCreator.fileWithDataCreator(newData);
            addParticipantsFromJsonFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showClubParticipants() {
        if (this.zooClub.isEmpty()) {
            System.out.println("zoo club has no participants");
            return;
        }

        this.zooClub.forEach((person, pets) -> {
            if (pets.isEmpty()) {
                System.out.println("\n" + person + "\n no pets");

            } else {
                System.out.println("\n" + person + "\n pet(s):");
                pets.forEach(System.out::println);
            }
        });
    }
}
