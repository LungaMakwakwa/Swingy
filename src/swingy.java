import Controller.CalculatorController;
import Modal.CalculatorModel;
import View.CalculatorView;

public class swingy {

    public static void main(String[] args) {

        CalculatorView theView = new CalculatorView();

        CalculatorModel theModel = new CalculatorModel();

        CalculatorController theController = new CalculatorController(theView,theModel);

        theView.setVisible(true);

    }
}