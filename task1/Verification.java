package task1;

public class Verification {
    public static void getVerification(IPAddress ipAddress) {
        if (ipAddress.getIpAddress().matches("^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$")) {
            System.out.println(ipAddress + " is valid");
        } else {
            System.out.println(ipAddress + " is not valid");
        }
    }
}
