package zooClub;

import lombok.*;
import org.json.JSONArray;
import org.json.JSONObject;
import zooClub.myExceptions.MyJSONException;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ZooClub {

    private Map<Person, List<Pet>> zooClub = new TreeMap<>();


    // from txt file using Serializable
    public void addParticipantsFromTxtFile() {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FolderWithDataCreator.getTxtFile()))) {
            Object obj = null;

            try {
                while ((obj = objectInputStream.readObject()) != null) {
                    this.zooClub.put(new Person(((Person) obj).getId(), ((Person) obj).getNickname(), ((Person) obj).getAge()),
                                     ((Person) obj).getPets());
                }
            } catch (EOFException e) {
                e.printStackTrace();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // from json file
    public void addParticipantsFromJsonFile() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getJsonFile()))) {

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


    public void addParticipant(Person person) {
        this.zooClub.putIfAbsent(person, new ArrayList<>());
    }


    public void addPetToParticipant(String nickName, Pet pet) {
       this.zooClub.keySet().forEach(person -> {
           if (person.getNickname().equals(nickName)) {
               this.zooClub.get(person).add(pet);
           }
       });
    }


    public void removePetFromParticipant(String personNickname, String petName) {

        // work only when get data from json file
//        this.zooClub.keySet().forEach(person -> {
//            if (person.getNickname().equals(personNickname)) {
//                this.zooClub.get(person).removeIf(pet -> pet.getName().equals(petName));
//            }
//        });


        // work when get data from json and txt file
        this.zooClub = this.zooClub.entrySet().stream()
                            .collect(toMap(Map.Entry::getKey,
                                           personListEntry -> {
                                                if (personListEntry.getKey().getNickname().equals(personNickname)) {
                                                    return personListEntry.getValue().stream()
                                                                .filter(pet -> !pet.getName().equals(petName))
                                                                .collect(toList());

                                                }

                                                return personListEntry.getValue();
                                           },
                                           (oldKey, newKey) -> oldKey,
                                           TreeMap::new));
    }


    public void removeParticipant(String nickname) {
        this.zooClub = this.zooClub.entrySet().stream()
                            .filter(personListEntry -> !personListEntry.getKey().getNickname().equals(nickname))
                            .collect(toMap(Map.Entry::getKey,
                                           Map.Entry::getValue,
                                           (oldKey, newKey) -> oldKey,
                                           TreeMap::new));
    }


    public void removePetFromAllParticipants(String name) {

        // work only when get data from json file
//        this.zooClub.forEach((person, pets) -> pets.removeIf(pet -> pet.getName().equals(name)));


        // work when get data from json and txt file
        this.zooClub = this.zooClub.entrySet().stream()
                            .collect(toMap(Map.Entry::getKey,
                                           personListEntry -> personListEntry.getValue().stream()
                                                                    .filter(pet -> !pet.getName().equals(name))
                                                                    .collect(toList()),
                                           (oldKey, newKey) -> oldKey,
                                           TreeMap::new));
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






    // practice with json file

    public void addParticipantToJsonFile(JSONObject person) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getJsonFile()))) {

            JSONArray data = new JSONArray(bufferedReader.readLine());
            data.put(person);

            FolderWithDataCreator.jsonFileWithDataCreator(data);
            addParticipantsFromJsonFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addPetToParticipantToJsonFile(String nickname, JSONObject pet) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getJsonFile()))) {

            JSONArray data = new JSONArray(bufferedReader.readLine());

            data.forEach(o -> {
                JSONObject person = (JSONObject) o;

                if (person.get("nickname").equals(nickname)) {
                   person.getJSONArray("pets").put(pet);
                }
            });

            FolderWithDataCreator.jsonFileWithDataCreator(data);
            addParticipantsFromJsonFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeParticipantFromJsonFile(String nickname) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FolderWithDataCreator.getJsonFile()))) {

            JSONArray data = new JSONArray(bufferedReader.readLine());
            JSONArray newData = new JSONArray();

            data.forEach(o -> {
                JSONObject person = (JSONObject) o;

                if (!person.get("nickname").equals(nickname)) {
                    newData.put(person);
                }
            });

            FolderWithDataCreator.jsonFileWithDataCreator(newData);
            addParticipantsFromJsonFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
