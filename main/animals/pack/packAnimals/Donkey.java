package main.animals.pack.packAnimals;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.pack.Pack;

public class Donkey extends Pack{

    public Donkey(int id, String humanFriendsEnum, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, humanFriendsEnum, name, birthDate, commands);
    }
}
