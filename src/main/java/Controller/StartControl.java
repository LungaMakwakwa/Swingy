package Controller;


import View.StartGameView;

public class StartControl{

    private StartGameView view;

    public  StartControl(StartGameView view) {
        this.view = view;
    }

    public void onCreateHeroButtonPressed() {
        view.openCreateHero();
    }

    public void onSelectHeroButtonPressed() {
        view.openSelectHero();
    }

}
