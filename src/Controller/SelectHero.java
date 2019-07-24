package Controller;

import Modal.Hero;
import Modal.Play;
import View.SelectPlayerView;

import java.util.ArrayList;

public class SelectHero {


    private SelectPlayerView view;
    private Play play;

    public void SelectHeroController(SelectPlayerView view) {
        this.view = view;
        play = Play.getInstance();
    }

    /*public void onListElementSelected(int idx) {
        Hero hero = DataBase.selectHeroById(idx + 1);
        view.updateInfo(hero.toString());
    }*/

    /*public String[] getListData() {
        ArrayList<String> list = DataBase.selectAll();
        String[] listArr = new String[list.size()];
        listArr = list.toArray(listArr);
        return listArr;
    }*/

    public void onSelectButtonPressed(int idx) {
        Hero hero;
//        try {
//            hero = DataBase.selectHeroById(idx + 1);
//            hero.validateHero();
//        } catch (HeroValidationException e) {
//            view.showErrorMessage(e.getMessage());
//            return;
//        }

        //play.initGame(hero);
        view.openGame();
    }

    public void onCreateButtonPressed() {
        view.openCreateHero();
    }
}
