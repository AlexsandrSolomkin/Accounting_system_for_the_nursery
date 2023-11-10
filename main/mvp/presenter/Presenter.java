package main.mvp.presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import main.mvp.ui.View;
import main.service.Service;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addAnimals(String nameHF, LocalDate birthDateHF, ArrayList<String> commandsHF) {
        service.addAnimals(nameHF, birthDateHF, commandsHF);
        System.out.println("Добавление животного");
    }
}