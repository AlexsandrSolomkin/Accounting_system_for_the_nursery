package main.mvp.ui.commands;

import main.mvp.ui.View;

public class GetInfo implements Command{
    private View view;

    public GetInfo(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Show information about animals";
    }

    @Override
    public void execute() {
        view.getInfo();
    }
}
