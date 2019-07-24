package View;

import Controller.Controls;
import Controller.SelectHero;
import Controller.StartControl;

import java.util.Scanner;

public class SelectPlayerView {

//    void start();
//
//    void updateInfo(String info);
//
//    void showErrorMessage(String message);
//
//    void openGame();
//
//    void openCreateHero();

    private SelectHero controls;
    private int lastIdx = -1;

    @Override
    public void start() {
        controls = new SelectHero(this);

        getInput();
    }

    private void getInput() {
        Scanner scanner = Main.getScanner();

        System.out.println("Available heroes: ");
        //printHeroes(controls.getListData());

        System.out.println();
        System.out.println("CREATE - to create hero");
        System.out.println("NUMBER - enter number of available hero to see full information");
        System.out.println("SELECT - enter select after entering number");
        System.out.println("Commands (CREATE, NUMBER, SELECT):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("create".equalsIgnoreCase(input)) {
                controls.onCreateButtonPressed();
                break;
            } else if (isValidNumericString(input, controls.getListData().length)) {
                lastIdx = Integer.parseInt(input) - 1;
                controls.onListElementSelected(lastIdx);
            } else if ("select".equalsIgnoreCase(input) && lastIdx != -1) {
                controls.onSelectButtonPressed(lastIdx);
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private boolean isValidNumericString(String str, int max) {
        try {
            int n = Integer.parseInt(str);
            if (n <= 0 || n > max)
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void printHeroes(String[] heroes) {
        if (heroes.length == 0)
            System.out.println("No saved heroes");
        for (String hero : heroes) {
            System.out.println(hero);
        }
    }

    @Override
    public void updateInfo(String info) {
        System.out.println(info);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
        getInput();
    }

    @Override
    public void openGame() {
        new GamePlayView().start();
    }

    @Override
    public void openCreateHero() {
        new HeroCreationView().start();
    }


}
