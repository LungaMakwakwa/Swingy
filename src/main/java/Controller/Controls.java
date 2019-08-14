package Controller;

import DB.Database;
import Modal.Artifact.Armor;
import Modal.Artifact.Artifacts;
import Modal.Artifact.Helm;
import Modal.Artifact.Weapon;
import Modal.Hero;
import Modal.Play;
import Modal.Points;
import Modal.Villians;
import View.GamePlayView;

import java.util.Random;

public class Controls {

    private GamePlayView view;
    private Play play;
    private Points previousPosition;

    public Controls(GamePlayView view) {
        this.view = view;
        play = Play.getInstance();
        previousPosition = new Points(0, 0);
    }

    public void onStart() {
        view.update(play);
    }

    public void onPrintMap() {
        view.printMap(play.getMap(), play.getHeroCoord());
        view.update(play);
    }

    public void onMove(String direction) {
        int x = play.getHeroCoord().getX();
        int y = play.getHeroCoord().getY();
        previousPosition.setX((int)x);
        previousPosition.setY((int)y);

        switch (direction.toUpperCase()) {
            case "W":
                y--;
                break;
            case "D":
                x++;
                break;
            case "S":
                y++;
                break;
            case "A":
                x--;
                break;
        }

        if (x < 0 || y < 0 || x >= play.getMapSize() || y >= play.getMapSize()) {
            winGame();
            return;
        }

        play.getHeroCoord().setX(x);
        play.getHeroCoord().setY(y);

        if (play.getMap()[y][x]) {
            villainCollision();
        }

        if (play.getHero().getHitPoints() > 0)
            view.update(play);
    }

    private void winGame() {
        view.showMessage("How you feel about getting  " + play.getMapSize() * 100 + "xp!");
        addExperience(play.getMapSize() * 100);
        updateDataBase();
        view.gameFinished();
    }

    private void updateDataBase() {
        Hero hero = play.getHero();
        Database.updateHero(hero);
    }

    private void villainCollision() {
        view.getVillainCollisionInput();
    }

    public void onRun() {
        if (new Random().nextBoolean()) {
            view.showMessage("You escaped!");
            play.getHeroCoord().setX(previousPosition.getX());
            play.getHeroCoord().setY(previousPosition.getY());
        } else {
            view.showMessage("You have to fight");
            onFight();
        }
    }

    private void setArtifact(Artifacts artifacts) {
        if (artifacts != null) {
            if (artifacts instanceof Weapon) {
                if (play.getHero().getWeapon() == null || view.replaceArtifact("your weapon: " + play.getHero().getWeapon() + ", found: " + artifacts)) {
                    play.getHero().equipWeapon((Weapon) artifacts);
                    view.showMessage("You equipped new weapon: " + artifacts);
                }
            } else if (artifacts instanceof Helm) {
                if (play.getHero().getHelm() == null || view.replaceArtifact("your helmet: " + play.getHero().getHelm() + ", found: " + artifacts)) {
                    play.getHero().equipHelm((Helm) artifacts);
                    view.showMessage("You equipped new helm: " + artifacts);
                }
            } else if (artifacts instanceof Armor) {
                if (play.getHero().getArmor() == null || view.replaceArtifact("your armor: " + play.getHero().getArmor() + ", found: " + artifacts)) {
                    play.getHero().equipArmor((Armor) artifacts);
                    view.showMessage("You equipped new armor: " + artifacts);
                }
            }
        }
    }

    public void onFight() {
        Villians villians = play.generateVillain();
        int xp = play.fightResult(villians);

        if (xp >= 0) {
            view.showMessage("You BEASTED\nThat dude How you feel about: " + xp + "xp.");
            addExperience(xp);
            play.getMap()[play.getHeroCoord().getY()][play.getHeroCoord().getX()] = false;
            setArtifact(villians.getArtifact());
        } else {
            view.showMessage("You Played yourself\nDEEEEAAAAAD");
            view.gameFinished();
        }
    }

    private void addExperience(int addXP) {
        int level = play.getHero().getLevel();
        play.getHero().addExperience(addXP);
        if (level != play.getHero().getLevel())
            view.showMessage("Level UP!\nHP, attack and defense were increased!");
    }

}
