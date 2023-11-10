package main.mvp.ui.commands;

import main.mvp.ui.View;

public class AddAnimals implements Command{
    private View view;

    public AddAnimals(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "add animal";
    }

    @Override
    public void execute() {
        view.addAnimals();
    }
}
