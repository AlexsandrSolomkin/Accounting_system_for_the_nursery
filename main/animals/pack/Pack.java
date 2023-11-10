package main.animals.pack;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriends;

public class Pack extends HumanFriends{

    public Pack(int id, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, name, birthDate, commands);
    }
}
