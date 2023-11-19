package main.mvp.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.animals.HumanFriendsEnum;
import main.mvp.presenter.Presenter;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flagWork;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        flagWork = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (flagWork) {
            System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Animal registry\n");
            System.out.println(mainMenu.printMenu());
            // ПРОВЕРКА НА КОРРЕКТНОСТЬ ВВОДА:
            int choice = inputNumMenu();

            if (choice == -1) {
                System.out.println("Input error");
                continue;
            }

            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            System.out.println("Такого действия нет в меню");
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }

        int choice = Integer.parseInt(line);

        return choice > 0 && choice <= mainMenu.size();
    }

    public void addAnimals() {

        System.out.println("Animal: ");
        String humanFriendsEnum = elementArrayListEnum();
        String fake2 = scanner.nextLine(); // <- затычка

        System.out.println("Name: ");
        String nameHumanFriend = scanner.nextLine();

        System.out.println("Date of birth: "); //"2018-05-05"
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        
        System.out.println("Commands: ");
        ArrayList<String> commands = new ArrayList<>();
        boolean flagAddCommand = true;

        while (flagAddCommand) {

            System.out.println("To add a command, enter '1', to exit '2': ");
            int answer = scanner.nextInt();
            
            if (answer == 1) {
                System.out.println("Enter the command for the animal");
                String fake = scanner.nextLine(); // <- затычка
                String commandInput = scanner.nextLine();
                commands.add(commandInput);
            } else if (answer == 2) {
                flagAddCommand = false;
            }
        }
        presenter.addAnimals(humanFriendsEnum, nameHumanFriend, birthDate, commands);
    }

    private String elementArrayListEnum(){
        List<HumanFriendsEnum> animals = new ArrayList<>();

        System.out.println("All animals: ");
        for (HumanFriendsEnum HFEnum : HumanFriendsEnum.values()) {
            animals.add(HFEnum);
            System.out.printf("%d. ", animals.size());
            System.out.println(HFEnum.getTitle());
        }

        System.out.println();
        int elEnum = scanner.nextInt();
        String animal = animals.get(elEnum - 1).getTitle();

        return animal;        
    }

    @Override
    public void addCommandAnimal() {
        getInfo();

        System.out.println("Inter id animal: ");
        int idAnimal = scanner.nextInt();
        System.out.println("New command: ");
        String fake = scanner.nextLine(); // <- затычка
        String newCommand = scanner.nextLine();

        presenter.addCommandAnimal(idAnimal, newCommand);
    }
    
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void writeDataInFile() {
        String pathFile = "main/database/dataFiles/database.txt";
        presenter.writeDataInFile(pathFile);
    }

    @Override
    public void readDataInFile(){
        String pathFile = "main/database/dataFiles/database.txt";
        presenter.readDataInFile(pathFile);
    }

    @Override
    public void getInfo() {
        presenter.getInfo();
    }

    @Override
    public void exitWorkProgramm() {
        System.out.println("Work is completed.");
        flagWork = false;
    }
}
