package main.service;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriends;
import main.animals.pet.Pet;
import main.database.DatabaseList;

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
}
