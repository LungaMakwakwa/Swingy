package DB;

import java.util.Scanner;

public class CloseDB {

    private static Scanner scanner;

    public static void closeConnections() {
       Database.close();
        if (scanner != null)
            scanner.close();
    }
}
