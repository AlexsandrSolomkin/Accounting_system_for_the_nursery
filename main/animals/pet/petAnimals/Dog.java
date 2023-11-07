package main.animals.pet.petAnimals;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.HumanFriendsEnum;
import main.animals.pet.Pet;

public class Dog extends Pet{

    public Dog(int id, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, name, birthDate, commands);
        setHumanFriendsEnum(HumanFriendsEnum.DOG);
    }
}
