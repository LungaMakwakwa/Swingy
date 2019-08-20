package View;

/* whole hero class without split*/

import Controller.CreateHero;

import java.util.Scanner;

public class HeroCreationView implements HeroCreationInterface {

    private CreateHero controls;

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void start() {
        controls = new CreateHero(this);

        getUserInput();
    }

    @Override
    public void getUserInput() {
        Scanner scanner = SelectPlayerView.getScanner();
        String name = "";

        System.out.println("To create hero enter his name and class.");
        while (name.length() < 2) {

            System.out.println("Enter name:");
            name = scanner.nextLine();
            if (name.length() < 2) {
                System.out.println(ANSI_RED + "Name Should be more than 2 charecters" + ANSI_RESET);
            }
        }

        System.out.println("+---------------------------------+");
        System.out.println("| CLASS  | ATTACK | DEFENSE | HP  |");
        System.out.println("|---------------------------------|");
        System.out.println("| Knight | 40     | 20      | 100 |");
        System.out.println("|---------------------------------|");
        System.out.println("| Elf    | 30     | 15      | 90  |");
        System.out.println("|---------------------------------|");
        System.out.println("| Priest | 25     | 25      | 90  |");
        System.out.println("+---------------------------------+");
        System.out.println("Enter" + ANSI_YELLOW + " class" + ANSI_RESET + " name: ");

        String heroClass = scanner.nextLine();

        System.out.println(ANSI_YELLOW + "CREATE" + ANSI_RESET + " - to create hero with previously entered Name and Class");
        System.out.println("Command (CREATE):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("create".equalsIgnoreCase(input)) {
                controls.onCreateButtonPressed(name, heroClass);
                break;
            } else {
                System.out.println(ANSI_RED + "Unknown command" + ANSI_RESET);
            }
        }
    }


    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    @Override
    public void openGame() {
        new StartGameView().start();
    }


}
