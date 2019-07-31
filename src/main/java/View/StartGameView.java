package View;

import Controller.StartControl;

import java.util.Scanner;

public class StartGameView implements StartGameInterface {



    private StartControl controller;

    @Override
    public void start() {

        //Main abc = new Main();
        controller = new StartControl(this);
        System.out.println("You are in console RPG game, enter available commands to play.");

        Scanner scanner = SelectPlayerView.getScanner();
        System.out.println();
        System.out.println("1 - to create hero");
        System.out.println("2 - to select already created hero");
        //System.out.println("SWITCH - to switch to GUI view");
        System.out.println("Commands (1, 2):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("1".equalsIgnoreCase(input)) {
                controller.onCreateHeroButtonPressed();
                break;
            } else if ("2".equalsIgnoreCase(input)) {
                controller.onSelectHeroButtonPressed();
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


   @Override
    public void openSelectHero() {
        new SelectPlayerView().start();
    }
}
