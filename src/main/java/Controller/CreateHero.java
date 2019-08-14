package Controller;

import DB.Database;
import Modal.Hero;
import Modal.HeroFactory;
import Modal.Play;
import View.HeroCreationView;

public class CreateHero {

    private HeroCreationView view;
    private Play play;

    public CreateHero(HeroCreationView view) {
        this.view = view;
        play = Play.getInstance();
    }

    public void onCreateButtonPressed(String name, String heroClass) {
        Hero hero;
        try {
            hero = HeroFactory.newHero(name, heroClass);
        } catch (IllegalArgumentException e) {
            view.showErrorMessage(e.getMessage());
            view.getUserInput();
            return;
        }

        int id = Database.insert(hero.getName(), hero.getHeroClass(), hero.getLevel(), hero.getExperience(), hero.getAttack(), hero.getDefense(), hero.getHitPoints());
        hero.setId(id);
        play.initGame(hero);
        view.openGame();
    }
}
