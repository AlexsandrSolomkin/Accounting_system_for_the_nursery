package main.animals.pet.petAnimals;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriendsEnum;
import main.animals.pet.Pet;

public class Cat extends Pet{

    public Cat(int id, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, name, birthDate, commands);
        setHumanFriendsEnum(HumanFriendsEnum.CAT);
    }
}
