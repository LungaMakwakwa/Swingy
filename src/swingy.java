import java.io.*;

public class swingy {




    //public int map = (level - 1) * 5 + 10 - (level % 2);


    public static void main(String[] args) throws IOException {



        String filename = "hero";
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int line = 1;
        String[] splitted;

        //while ((strLine = br.readLine()) != null) {
            strLine = br.readLine();
            splitted = strLine.split(",");
            System.out.println(splitted[2]);
            int level = Integer.parseInt(splitted[2]);
        //}
        int map = (level - 1) * 5 + 10 - (level % 2);
        System.out.println(map);


        //int map = 8;

        System.out.printf("MAP %d Map1 %d", map, map);
        System.out.println();
        int center = map / 2;
        for (int i = 0; i < map; i++) {
            for (int j = 0; j < map; j++) {

               if (j == center && i == center)
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