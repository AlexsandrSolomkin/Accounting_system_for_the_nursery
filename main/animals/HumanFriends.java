package main.animals;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class HumanFriends implements Serializable{
    private int id;
    private String name;
    private LocalDate birthDate;
    private ArrayList<String> commands;
    private HumanFriendsEnum humanFriendsEnum;

    public HumanFriends(int id, String name, LocalDate birthDate, ArrayList<String> commands) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
    
    public HumanFriendsEnum getHumanFriendsEnum() {
        return humanFriendsEnum;
    }

    public void setHumanFriendsEnum(HumanFriendsEnum humanFriendsEnum) {
        this.humanFriendsEnum = humanFriendsEnum;
    }
}
