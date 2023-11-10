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
        ArrayList<String> commands;
        boolean flagAddCommand = true;

        while (flagAddCommand) {
            
            System.out.println("To add a command, enter 1, to exit 2: ");
            int answer = scanner.nextInt();

            if (answer == 1) {
                commands.add(scanner.nextLine());
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
    /*
    @Override
    public void getProduct() {
        presenter.getProduct();
    }

    @Override
    public void getInfoWinner(){
        presenter.getInfoWinner();
    }

    @Override
    public void setProbability(){
        System.out.println("Введите id нужного товара: ");
        int index = scanner.nextInt();
        System.out.println("Введите вес: ");
        int probability = scanner.nextInt();
        presenter.setProbability(index, probability);
    }

    @Override
    public void prizeDrawing(){
        System.out.println("Введите имя победителя: ");
        String nameWinner = scanner.nextLine();
        presenter.prizeDrawing(nameWinner);
    }

    @Override
    public void writeDataInFile(){
        // StringBuilder startName = new StringBuilder();
        // startName.append("dataProducts/dataFiles/data");
        // System.out.println("Для корректной работы системы, в началеимени файла будет указан префикс: dataВашеНазваниеФайла.txt");
        // System.out.println("Введите название файла, в котором будут хранить данные на текущий момент: ");
        
        String pathFile = "main/dataProducts/dataFiles/dataProducts.txt";
        // startName.append(nameFile).append(".txt");
        presenter.writeDataInFile(pathFile);
    }

    @Override
    public void readDataInFile(){
        String pathFile = "main/dataProducts/dataFiles/dataProducts.txt";
        presenter.readDataInFile(pathFile);
    }

    @Override
    public void exitWorkProgramm() {
        System.out.println("Работа завершена.");
        flagWork = false;
    }
    */
}
