package main.mvp.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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
        presenter.addAnimals(nameHumanFriend, birthDate, commands);
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
    public void exitWorkProgramm() {
        System.out.println("Work is completed.");
        flagWork = false;
    }

    @Override
    public void getInfo() {
        presenter.getInfo();
    }
}
