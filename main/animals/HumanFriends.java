package main.animals;

import java.sql.Date;
import java.util.ArrayList;

public abstract class HumanFriends {
    private int id;
    private String name;
    private Date birthDate;
    private ArrayList<String> commands;

    public HumanFriends(int id, String name, Date birthDate, ArrayList<String> commands) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
}
