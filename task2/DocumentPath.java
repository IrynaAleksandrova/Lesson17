package task2;

import java.util.Scanner;

public class DocumentPath {
    private static final Scanner scanner = new Scanner(System.in);

    private static int inputDocsQuantity() {
        return scanner.nextInt();
    }

    private static String inputPathToFolder() {
        return scanner.nextLine();
    }

    public static int getInputDocsQuantity() {
        return inputDocsQuantity();
    }

    public static String getInputPathToFolder() {
        return inputPathToFolder();
    }
}
