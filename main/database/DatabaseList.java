package main.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.animals.HumanFriends;

public class DatabaseList implements Iterable<HumanFriends>, Serializable {
    private List<HumanFriends> databaseList;

    public DatabaseList() {
        databaseList = new ArrayList<>();
    }

    public void addHumanFriends(HumanFriends humanFriends) {
        databaseList.add(humanFriends);
    }

    public void getHumanFriends(int index){
        databaseList.get(index);
    }

    public HumanFriends getObject(int index){
         return databaseList.get(index);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animals:\n");

        for (HumanFriends animal : databaseList) {
            stringBuilder.append("\n=============================");
            stringBuilder.append("\nid: ")
                    .append(animal.getId())
                    .append("\nName: ")
                    .append(animal.getName())
                    .append("\nCommands: ")
                    .append(animal.getCommands());
            stringBuilder.append("\n=============================");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<HumanFriends> iterator() {
        return new ObjectIterator(databaseList);
    }
}
