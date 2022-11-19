package task1;

public class Main {
//    Написать программу для проверки на валидность введенного ip адреса.
//    Пусть ip адрес задается с консоли.
//    Программа должна проверять валидность введенного ip адреса с
//    помощью регулярного выражения и выводить результат проверки на экран.

    public static void main(String[] args) {

        IPAddress ipAddress = new IPAddress("255.12.158.36");
        Verification.getVerification(ipAddress);

        IPAddress ipAddress1 = new IPAddress("256.256.200.155");
        Verification.getVerification(ipAddress1);
    }
}