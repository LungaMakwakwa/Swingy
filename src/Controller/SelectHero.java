package Controller;

import Modal.Hero;
import Modal.Play;
import View.SelectPlayerView;

import java.util.ArrayList;

public class SelectHero {


    private SelectPlayerView view;
    private Play play;

    public SelectHero(SelectPlayerView view) {
        this.view = view;
        play = Play.getInstance();
    }

    /*public void onListElementSelected(int idx) {
        Hero hero = DataBase.selectHeroById(idx + 1);
        view.updateInfo(hero.toString());
    }*/

    public void onListElementSelected(int idx)
    {
        System.out.println("hero on list");
    }

    public String[] getListData()
    {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        String[] car = new String[cars.size()];
        car = cars.toArray(car);
        return (car);
    }



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
