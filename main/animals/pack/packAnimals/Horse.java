package main.animals.pack.packAnimals;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriendsEnum;
import main.animals.pack.Pack;

public class Horse extends Pack{

    public Horse(int id, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, name, birthDate, commands);
        setHumanFriendsEnum(HumanFriendsEnum.HORSE);
    }
}
