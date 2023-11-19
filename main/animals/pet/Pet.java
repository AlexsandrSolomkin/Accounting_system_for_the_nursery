package main.animals.pet;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriends;

public class Pet extends HumanFriends{

    public Pet(int id, String humanFriendsEnum, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, humanFriendsEnum, name, birthDate, commands);
    }
}
