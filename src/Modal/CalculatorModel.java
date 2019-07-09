package Modal;


//the modal performs all the calculations needed
// and that is it. I doesnt know the view exist

public class CalculatorModel {

    private int calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public int getCalculationValue(){

        return calculationValue;

    }
}
