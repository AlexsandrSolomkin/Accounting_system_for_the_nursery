package main.animals.pet.petAnimals;

import java.time.LocalDate;
import java.util.ArrayList;

import main.animals.pet.Pet;

public class Cat extends Pet{

    public Cat(int id, String humanFriendsEnum, String name, LocalDate birthDate, ArrayList<String> commands) {
        super(id, humanFriendsEnum, name, birthDate, commands);
    }
}
