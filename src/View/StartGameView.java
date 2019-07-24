package View;

import Controller.StartControl;

import java.util.Scanner;
import

public class StartGameView {

//    void start();
//
//    void openCreateHero();
//
//    void switchView();
//
//    void openSelectHero();

    private StartControl controller;

    @Override
    public void start() {

        controller = new StartControl(this);
        System.out.println("You are in console RPG game, enter available commands to play.");

        Scanner scanner = Main.getScanner();
        System.out.println();
        System.out.println("CREATE - to create hero");
        System.out.println("SELECT - to select already created hero");
        System.out.println("SWITCH - to switch to GUI view");
        System.out.println("Commands (CREATE, SELECT, SWITCH):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("create".equalsIgnoreCase(input)) {
                controller.onCreateHeroButtonPressed();
                break;
            } else if ("select".equalsIgnoreCase(input)) {
                controller.onSelectHeroButtonPressed();
                break;
            } else if ("switch".equalsIgnoreCase(input)) {
                controller.onSwitchButtonPressed();
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    @Override
    public void openCreateHero() {
        new HeroCreationView().start();
    }

    /*@Override
    public void switchView() {
        new StartViewGUI().start();
    }*/

    @Override
    public void openSelectHero() {
        new SelectPlayerView().start();
    }
}
