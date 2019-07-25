package Controller;

import DB.Database;
import Modal.Hero;
import Modal.Play;
import View.SelectPlayerView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SelectHero {


    private SelectPlayerView view;
    private Play play;

    public SelectHero(SelectPlayerView view) {
        this.view = view;
        play = Play.getInstance();
    }

    public void onListElementSelected(int idx) {
        Hero hero = Database.selectHeroById(idx + 1);
        view.updateInfo(hero.toString());
    }

//    public void onListElementSelected(int idx)
//    {
//        String fileName = "hero";
//        String line = null;
//
//        try {
//            // FileReader reads text files in the default encoding.
//            FileReader fileReader =
//                    new FileReader(fileName);
//
//            // Always wrap FileReader in BufferedReader.
//            BufferedReader bufferedReader =
//                    new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            // Always close files.
//            bufferedReader.close();
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println("Unable to open file '" + fileName + "'");
//        }
//        catch(IOException ex) {
//            System.out.println("Error reading file '" + fileName + "'");
//            // Or we could just do this:
//            // ex.printStackTrace();
//        }
//        view.openGame();
//    }

        //System.out.println("hero on list");
    //}

//    public String[] getListData()
//    {
//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        String[] car = new String[cars.size()];
//        car = cars.toArray(car);
//        return (car);
//    }



    public String[] getListData() {
        ArrayList<String> list = Database.selectAll();
        String[] listArr = new String[list.size()];
        listArr = list.toArray(listArr);
        return listArr;
    }

    public void onSelectButtonPressed(int idx) {
        Hero hero;
        try {
            hero = Database.selectHeroById(idx + 1);
            //hero.validateHero();
        } catch (Exception e) {
            view.showErrorMessage(e.getMessage());
            return;
        }

        play.initGame(hero);
        view.openGame();
    }

    public void onCreateButtonPressed() {
        view.openCreateHero();
    }
}
