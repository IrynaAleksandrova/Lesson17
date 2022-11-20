package task2;

public class ProcessExceptions {

    private static String wrongFormat() {
        return " has wrong extension. Supporting only txt format";
    }

    private static String noFiles() {
        return "Directory has 0 files";
    }

    private static String belowZero() {
        return "Docs quantity to check must be > 0";
    }

    public static String getWrongFormat() {
        return wrongFormat();
    }

    public static String getNoFiles() {
        return noFiles();
    }

    public static String getBelowZero() {
        return belowZero();
    }
}
