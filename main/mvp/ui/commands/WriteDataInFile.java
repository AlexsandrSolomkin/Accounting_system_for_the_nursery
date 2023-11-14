package main.mvp.ui.commands;

import main.mvp.ui.View;

public class WriteDataInFile implements Command{
    private View view;

    public WriteDataInFile(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Write data";
    }

    @Override
    public void execute() {
        view.writeDataInFile();
    }
}
