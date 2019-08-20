package View;

import Controller.Controls;
import DB.CloseDB;
import Modal.Play;
import Modal.Points;

import java.util.Scanner;

public class GamePlayView implements GamePlayViewInterface{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";


    private Controls controls;

    @Override
    public void start() {
        controls = new Controls(this);

        controls.onStart();
    }

    @Override
    public void update(Play play) {
        System.out.println("----------INFO----------");
        System.out.println(play.getHero().toString() +
                "Position: " + "(" + play.getHeroCoord().getX() +
                "," + play.getHeroCoord().getY() + ")");
        System.out.println("------------------------");

        printMap(play.getMap(), play.getHeroCoord());
        getUserInput();
    }

    private void getUserInput() {
        Scanner scanner = SelectPlayerView.getScanner();

        System.out.println(ANSI_GREEN + "W: " + ANSI_RESET + "UP, " + ANSI_GREEN + "D: " + ANSI_RESET + "RIGHT, " + ANSI_GREEN + "S: " + ANSI_RESET + "Down, " + ANSI_GREEN + "A: " + ANSI_RESET + "LEFT - to move to this direction");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("map".equalsIgnoreCase(input)) {
                controls.onPrintMap();
                break;
            } else if ("W".equalsIgnoreCase(input) ||
                    "D".equalsIgnoreCase(input) ||
                    "S".equalsIgnoreCase(input) ||
                    "A".equalsIgnoreCase(input)) {
                controls.onMove(input);
                break;
            } else {
                System.out.println(ANSI_RED + "Unknown command" + ANSI_RESET);
            }
        }
    }

    @Override
    public void printMap(boolean[][] map, Points heroCoord) {
        System.out.printf("MAP %dx%d", map.length, map.length);
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (heroCoord.getX() == j && heroCoord.getY() == i)
                    System.out.print("[" + ANSI_BLUE + " H " + ANSI_RESET + "]");
                else if (map[i][j])
                    System.out.print("[" + ANSI_RED + " * " + ANSI_RESET + "]");
                else
                    System.out.print("[ . ]");
            }
            System.out.println();
        }
    }

    @Override
    public void gameFinished() {
        CloseDB.closeConnections();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void getVillainCollisionInput() {
        Scanner scanner = SelectPlayerView.getScanner();

        System.out.println();
        System.out.println("You moved to position occupied by villain");
        System.out.println("F - to fight with villain");
        System.out.println("R - If he catch you. You have no choice but fight");
        System.out.println("Commands (FIGHT, RUN):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("F".equalsIgnoreCase(input)) {
                controls.onFight();
                break;
            } else if ("R".equalsIgnoreCase(input)) {
                controls.onRun();
                break;
            } else {
                System.out.println(ANSI_RED + "Unknown command" + ANSI_RESET);
            }
        }
    }

    @Override
    public boolean replaceArtifact(String replaceMessage) {
        Scanner scanner = SelectPlayerView.getScanner();

        System.out.println();
        System.out.println("Would you like to replace " + ANSI_BLUE + replaceMessage + ANSI_RESET + "?");
        System.out.println("1 - to " + ANSI_RED + "LEAVE " + ANSI_RESET + "your artifact");
        System.out.println("2 - to " + ANSI_RED + "REPLACE " + ANSI_RESET + "by new artifact");
        System.out.println("Commands (1, 2):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("1".equalsIgnoreCase(input)) {
                return false;
            } else if ("2".equalsIgnoreCase(input)) {
                return true;
            } else {
                System.out.println(ANSI_RED + "Unknown command" + ANSI_RESET);
            }
        }
        return false;
    }

    @Override
    public void switchView() {
        new StartGameView().start();
    }
}
