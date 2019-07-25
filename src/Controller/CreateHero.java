package Controller;

import Modal.Hero;
import Modal.HeroCreation;
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
        //try {
        //    hero = HeroFactory.newHero(name, heroClass);
        //    hero.validateHero();
            System.out.println("hero created");
        //} catch (IllegalArgumentException | HeroValidationException e) {
         ///   view.showErrorMessage(e.getMessage());
          //  view.getUserInput();
           // return;
        }

     /*   int id = DataBase.insert(hero.getName(), hero.getHeroClass(), hero.getLevel(), hero.getExperience(), hero.getAttack(), hero.getDefense(), hero.getHitPoints());
        hero.setId(id);
        game.initGame(hero);*/
        //view.openGame();
    //}
}
