package task2;

import java.util.Scanner;

public class DocumentPath {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputDocsQuantity() {
        return SCANNER.nextInt();
    }

    public static String inputPathToFolder() {
        return SCANNER.nextLine();
    }

    public static void close(){
        SCANNER.close();
    }

}