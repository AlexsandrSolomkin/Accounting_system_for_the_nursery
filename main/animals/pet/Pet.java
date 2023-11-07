package main.animals.pet;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriends;

public abstract class Pet extends HumanFriends{

    public Pet(int id, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, name, birthDate, commands);
    }
}
