package main.service;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriends;
import main.animals.pet.Pet;
import main.database.DatabaseList;
import main.database.workDatabase.FileHandler;
import main.database.workDatabase.Writable;

public class Service {
    private int id;
    private DatabaseList databaseList;


    public Service(DatabaseList databaseList) {
        this.databaseList = databaseList;
    }

    public Service() {
        this(new DatabaseList());
    }

    public void addAnimals(String nameHF, LocalDate birthDateHF, ArrayList<String> commandsHF) {
        HumanFriends humanFriends = new Pet(id++, nameHF, birthDateHF, commandsHF);
        // HumanFriends humanFriends = new Pack(id++, nameHF, birthDateHF, commandsHF);
        databaseList.addHumanFriends(humanFriends);
    }

    public void writeDataInFile(String path){
        Writable writable = new FileHandler();
        writable.write(databaseList, path);
    }

    public void readDataInFile(String path){
        Writable writable = new FileHandler();
        databaseList = (DatabaseList) writable.read(path);
        //////////////////////////////////////////////
        //System.out.println(databaseList.getInfo());
        //////////////////////////////////////////////
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animals:\n");

        for (HumanFriends animal : databaseList) {
            stringBuilder.append("\n=============================");
            stringBuilder.append("\nid: ")
                    .append(animal.getId())
                    .append("\nName: ")
                    .append(animal.getName())
                    .append("\nCommands: ")
                    .append(animal.getCommands());
            stringBuilder.append("\n=============================");
        }
        return stringBuilder.toString();
    }
}
