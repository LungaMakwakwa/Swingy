package View;

import Modal.Play;
import Modal.Points;

public interface GamePlayViewInterface {

    void start();

    void printMap(boolean[][] map, Points heroCoord);

    void update(Play play);

    void gameFinished();

    void showMessage(String message);

    void getVillainCollisionInput();

    boolean replaceArtifact(String replaceMessage);

    void switchView();
}
