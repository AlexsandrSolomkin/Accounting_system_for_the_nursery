package main.mvp.ui.commands;

import main.mvp.ui.View;

public class AddCommandAnimal implements Command{
    private View view;

    public AddCommandAnimal(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Add command animal";
    }

    @Override
    public void execute() {
        view.addCommandAnimal();
    }
}
