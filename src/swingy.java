import Controller.CalculatorController;
import Modal.CalculatorModel;
import View.CalculatorView;

public class swingy {



    public int map = (level - 1) * 5 + 10 - (level % 2);


    public static void main(String[] args) {

        int map = 8;

        System.out.printf("MAP %d Map1 %d", map, map);
        System.out.println();
        for (int i = 0; i < map; i++) {
            for (int j = 0; j < map; j++) {

               if (j == 4 && i == 4)
                    System.out.print("H. ");
//                else if (map[i][j])
 //                   System.out.print("* ");
                else
                    System.out.print(" . ");
            }
            System.out.println();
        }

        //CalculatorView theView = new CalculatorView();

        //CalculatorModel theModel = new CalculatorModel();

        //CalculatorController theController = new CalculatorController(theView,theModel);

        //theView.setVisible(true);

    }
}