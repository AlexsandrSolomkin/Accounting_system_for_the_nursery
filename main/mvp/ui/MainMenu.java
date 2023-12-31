package main.mvp.ui;

import java.util.ArrayList;
import java.util.List;

import main.mvp.ui.commands.*;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddAnimals(view));
        commandList.add(new AddCommandAnimal(view));
        commandList.add(new WriteDataInFile(view));
        commandList.add(new ReadDataInFile(view));
        commandList.add(new GetInfo(view));
        commandList.add(new ExitWorkProgramm(view));
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commandList.size();
    }
}