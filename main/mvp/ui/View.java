package main.mvp.ui;

import main.mvp.presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    
    void setPresenter(Presenter presenter);

    void addAnimals();
    void writeDataInFile();
}
