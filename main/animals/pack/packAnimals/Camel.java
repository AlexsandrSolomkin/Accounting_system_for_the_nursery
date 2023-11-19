package main.animals.pack.packAnimals;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.pack.Pack;

public class Camel extends Pack{

    public Camel(int id, String humanFriendsEnum, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, humanFriendsEnum, name, birthDate, commands);
    }
}
